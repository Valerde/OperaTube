package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Article;
import com.sovava.video.entity.Category;
import com.sovava.video.service.CategoryService;
import com.sovava.video.dao.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author root
 * @description 针对表【category】的数据库操作Service实现
 * @createDate 2023-01-13 22:17:14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Category> page = this.page(
                new Query<Category>().getPage(params),
                new QueryWrapper<Category>()
        );

        return new PageUtils(page);

    }

    @Override
    public List<Category> getCategoryWithTree() {
        List<Category> categories = this.baseMapper.selectList(null);

        List<Category> categories1Level = categories.stream().filter((item) -> item.getFatherId() == 0)
                .peek(item -> item.setChildren(getChildren(item, categories)))
                .sorted(Comparator.comparingInt(item -> item.getSort() == null ? 0 : item.getSort()))
                .collect(Collectors.toList());
        return categories1Level;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {

        Category category = this.baseMapper.selectById(categoryId);
        return category;
    }

    private List<Category> getChildren(Category category, List<Category> categories) {
        Integer fatherId = category.getId();

        List<Category> collect = categories.stream().filter((item) -> item.getFatherId().equals(fatherId))
                .peek(item -> item.setChildren(getChildren(item, categories)))
                .sorted(Comparator.comparingInt(item -> item.getSort() == null ? 0 : item.getSort()))
                .collect(Collectors.toList());

        return collect;

    }
}




