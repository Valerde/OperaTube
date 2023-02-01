package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.FavoritesTable;
import com.sovava.video.service.FavoritesTableService;
import com.sovava.video.dao.FavoritesTableMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【favorites_table(收藏夹)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class FavoritesTableServiceImpl extends ServiceImpl<FavoritesTableMapper, FavoritesTable>
    implements FavoritesTableService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FavoritesTable> page = this.page(
                new Query<FavoritesTable>().getPage(params),
                new QueryWrapper<FavoritesTable>()
        );

        return new PageUtils(page);

    }
}




