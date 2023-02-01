package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.LikeTable;
import com.sovava.video.service.LikeTableService;
import com.sovava.video.dao.LikeTableMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【like_table(点赞)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class LikeTableServiceImpl extends ServiceImpl<LikeTableMapper, LikeTable>
    implements LikeTableService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LikeTable> page = this.page(
                new Query<LikeTable>().getPage(params),
                new QueryWrapper<LikeTable>()
        );

        return new PageUtils(page);

    }
}




