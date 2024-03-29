package com.sovava.product.service.impl;

//import com.alibaba.fastjson.TypeReference;

import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sovava.common.constant.ProductConstant;
import com.sovava.common.to.SkuReductionTo;
import com.sovava.common.to.SpuBoundTo;
import com.sovava.common.to.es.SpuEsModel;
import com.sovava.common.utils.R;
import com.sovava.product.entity.*;
import com.sovava.product.feign.CouponFeignService;
import com.sovava.product.feign.SearchFeignService;
import com.sovava.product.feign.WareFeignService;
import com.sovava.product.service.*;
import com.sovava.product.vo.*;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;

import com.sovava.product.dao.SpuInfoDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


@Service("spuInfoService")
@Slf4j
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Resource
    private SpuInfoDescService spuInfoDescService;

    @Resource
    private AttrService attrService;

    @Resource
    private SpuImagesService spuImagesService;

    @Resource
    private ProductAttrValueService productAttrValueService;

    @Resource
    private SkuInfoService skuInfoService;

    @Resource
    private SkuImagesService skuImagesService;

    @Resource
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Resource
    private CouponFeignService couponFeignService;

    @Resource
    private BrandService brandService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private WareFeignService wareFeignService;

    @Resource
    private SearchFeignService searchFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void saveSpuInfo(SpuSaveVo spuSaveVo) {
        //1. 保存spu基本信息 pms_spu_info
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtils.copyProperties(spuSaveVo, spuInfoEntity);
        spuInfoEntity.setCreateTime(new Date());
        spuInfoEntity.setUpdateTime(new Date());
        this.save(spuInfoEntity);
        //2. 保存spu的描述图片 pms_spu_info_desc
        List<String> decript = spuSaveVo.getDecript();
        SpuInfoDescEntity spuInfoDescEntity = new SpuInfoDescEntity();
        spuInfoDescEntity.setSpuId(spuInfoEntity.getId());
        spuInfoDescEntity.setDecript(String.join(";", decript));

        spuInfoDescService.saveSpuInfoDesc(spuInfoDescEntity);
        //3. 保存spu的图片集 pms_spu_images
        List<String> images = spuSaveVo.getImages();

        spuImagesService.saveImages(spuInfoEntity.getId(), images);
        //4. 保存商品的规格参数pms_product_attr_value
        List<BaseAttrs> baseAttrs = spuSaveVo.getBaseAttrs();
        List<ProductAttrValueEntity> productAttrValueEntities = baseAttrs.stream().map((attr) -> {
            ProductAttrValueEntity valueEntity = new ProductAttrValueEntity();
            valueEntity.setSpuId(spuInfoEntity.getId());
            valueEntity.setAttrValue(attr.getAttrValues());
            valueEntity.setAttrId(attr.getAttrId());
            valueEntity.setQuickShow(attr.getShowDesc());
            AttrEntity tempAttr = attrService.getById(attr.getAttrId());
            if (tempAttr != null)
                valueEntity.setAttrName(tempAttr.getAttrName());
            return valueEntity;
        }).collect(Collectors.toList());

        productAttrValueService.saveProductAttr(productAttrValueEntities);

        //4.5 保存spu的积分信息 sms_spu_bounds
        Bounds bounds = spuSaveVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuInfoEntity.getId());
        R r = couponFeignService.saveSpuBounds(spuBoundTo);
        int code = r.getCode();
        if (code != 0) {
            log.error("保存spu的积分信息处理失败");
        }

        //5. 保存当前spu对应的的sku信息
        //5.1 保存sku的基本信息 pms_sku_info

        List<Skus> skus = spuSaveVo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.forEach((item) -> {
                String defaultImage = null;

                for (Images img : item.getImages()) {
                    if (img.getDefaultImg() == 1) {
                        defaultImage = img.getImgUrl();
                    }
                }

                SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
                BeanUtils.copyProperties(item, skuInfoEntity);
                skuInfoEntity.setBrandId(spuInfoEntity.getBrandId());
                skuInfoEntity.setCatalogId(spuSaveVo.getCatalogId());
                skuInfoEntity.setSaleCount(0L);
                skuInfoEntity.setSpuId(spuInfoEntity.getId());
                skuInfoEntity.setSkuDefaultImg(defaultImage);

                skuInfoService.save(skuInfoEntity);
                //5.2 保存sku的图片信息pms_sku_images
                Long skuId = skuInfoEntity.getSkuId();


                List<SkuImagesEntity> skuImagesEntities = item.getImages().stream().map(images1 -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setDefaultImg(images1.getDefaultImg());
                    skuImagesEntity.setImgUrl(images1.getImgUrl());

                    return skuImagesEntity;
                }).filter((entity) -> {
                    //返回true需要 ， false就是不需要
                    return !StringUtils.isEmpty(entity.getImgUrl());
                }).collect(Collectors.toList());


                skuImagesService.saveBatch(skuImagesEntities);

                //5.3 sku的销售属性信息pms_sku_sale_attr_value
                List<Attr> attr = item.getAttr();
                List<SkuSaleAttrValueEntity> skuSaleAttrValueEntities = attr.stream().map(attr1 -> {
                    SkuSaleAttrValueEntity skuSaleAttrValueEntity = new SkuSaleAttrValueEntity();
                    BeanUtils.copyProperties(attr1, skuSaleAttrValueEntity);
                    skuSaleAttrValueEntity.setSkuId(skuId);
                    return skuSaleAttrValueEntity;
                }).collect(Collectors.toList());
                skuSaleAttrValueService.saveBatch(skuSaleAttrValueEntities);


                //5.4 sku的优惠满减信息 gulimall_sms -> sms_sku_ladder / sms_sku_full_reduction / sms_member_price
                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                skuReductionTo.setSkuId(skuId);
                if (skuReductionTo.getDiscount().compareTo(new BigDecimal(0)) == 1 || skuReductionTo.getFullCount() > 0) {
                    R r1 = couponFeignService.saveSkuReduction(skuReductionTo);
                    if (r1.getCode() != 0) {
                        log.error("远程保存优惠信息失败");
                    }
                }

            });
        }


    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        LambdaQueryWrapper<SpuInfoEntity> lqw = new LambdaQueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            lqw.and((w) -> {//如果不用这里的and，那么sql语句拼来以后就会是：status=1 and id=? or spu_name=？
                //          而加上and后 ， 就变成了status=1 and （id=? or spu_name=？）
                w.eq(SpuInfoEntity::getId, key).or().like(SpuInfoEntity::getSpuName, key);
            });
        }
        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status)) {
            lqw.eq(SpuInfoEntity::getPublishStatus, status);
        }
        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !brandId.equalsIgnoreCase("0")) {
            lqw.eq(SpuInfoEntity::getBrandId, brandId);
        }

        String catelogId = (String) params.get("catelog");
        if (!StringUtils.isEmpty(catelogId)) {
            lqw.eq(SpuInfoEntity::getCatalogId, catelogId);
        }
        IPage<SpuInfoEntity> page = this.page(new Query<SpuInfoEntity>().getPage(params), lqw);

        return new PageUtils(page);

    }

    @Override
    public void up(Long spuId) {
        List<SpuEsModel> upProducts;


        // 1. 查出当前spu对应的sku信息
        List<SkuInfoEntity> skus = skuInfoService.selectSkuBySpuId(spuId);

        //TO DO : 查询当前spu所有的可以被用来检索的规格属性 ， 应该把他提出来方在外面查一边
        List<ProductAttrValueEntity> baseAttrs = productAttrValueService.baseListforspuSpuId(spuId);
        List<Long> attrIds = baseAttrs.stream().map(ProductAttrValueEntity::getAttrId).collect(Collectors.toList());
        List<Long> searchAttrs = attrService.selectSearchAttrIds(attrIds);
        Set<Long> idSet = new HashSet<>(searchAttrs);
        List<SpuEsModel.Attrs> attrs1 = baseAttrs.stream().filter((item) -> {
            return idSet.contains(item.getAttrId());
        }).map((item) -> {
            SpuEsModel.Attrs attrs = new SpuEsModel.Attrs();
            attrs.setAttrId(item.getAttrId());
            attrs.setAttrValue(item.getAttrValue());
            attrs.setAttrName(item.getAttrName());
            return attrs;
        }).collect(Collectors.toList());


        List<Long> skuIds = skus.stream().map(SkuInfoEntity::getSkuId).collect(Collectors.toList());

//        TO DO： 发动远程调用 ， 查询是否有库存 , 当到外面统一查询
        Map<Long, Boolean> collect = null;
        try {
            R r = wareFeignService.selectHasStock(skuIds);
            Object data = r.get("data");
            TypeReference<List<SkuHasStockVo>> typeReference = new TypeReference<List<SkuHasStockVo>>() {
            };
            collect = r.getData(typeReference).stream().collect(Collectors.toMap(SkuHasStockVo::getSkuId, item -> item.getHasStock()));
        } catch (Exception ex) {
            log.debug("远程查询库存失败 , 原因{}", ex.getMessage());
            ex.printStackTrace();
        }

        //2. 封装每个sku的信息
        Map<Long, Boolean> finalCollect = collect;
        upProducts = skus.stream().map((sku) -> {
            //组装需要的数据
            SpuEsModel spuEsModel = new SpuEsModel();
            BeanUtils.copyProperties(sku, spuEsModel);
            //skuImage
            spuEsModel.setSkuImg(sku.getSkuDefaultImg());
            //price
            spuEsModel.setSkuPrice(sku.getPrice());
            //hasStock TO DO： 发动远程调用 ， 查询是否有库存 , 当到外面统一查询
            if (finalCollect == null) {
                spuEsModel.setHasStock(true);
            } else {
                spuEsModel.setHasStock(finalCollect.get(sku.getSkuId()));
            }
            //hotScore TODO ： 热度评分，比如商品刚上架或点击率很高 ， 就设置一个热度评分 默认设置为一个0
            spuEsModel.setHotScore(0L);
            //brandName
            BrandEntity brand = brandService.getById(spuEsModel.getBrandId());
            if (brand != null) {
                spuEsModel.setBrandName(brand.getName());
                //brandImg
                spuEsModel.setBrandImg(brand.getLogo());
            }

            //catalogName
            CategoryEntity category = categoryService.getById(spuEsModel.getCatalogId());
            if (category != null) {
                spuEsModel.setCatalogName(category.getName());
            }

            // 设置检索属性
            spuEsModel.setAttrs(attrs1);

            return spuEsModel;
        }).collect(Collectors.toList());

        //TODO 将数据发送给es进行保存 ， 通过gulimall-search
        R r = searchFeignService.productStatusUp(upProducts);
        if (r.getCode() == 0) {
            log.error("远程调用成功");
            //TODO 修改当前spu的状态为以上架
            this.baseMapper.updateSkuStatus(spuId, ProductConstant.StatusEum.SPU_UP.getCode());
        } else {
            //远程调用失败
            //TODO 如果重复调用 ， 接口幂等性
            //Feign的调用流程
            /**
             * 1. 构造请求数据原， 经对象转为json
             * 2. 发送请求进行执行（执行成功会解码响应数据）
             * 3. 执行请求会有重试机制
             */
        }

    }

    @Override
    public SpuInfoEntity getSpuInfoBySkuId(Long skuId) {

        SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
        Long spuId = skuInfo.getSpuId();
        SpuInfoEntity spuInfo = this.getById(spuId);
        return spuInfo;

    }

}