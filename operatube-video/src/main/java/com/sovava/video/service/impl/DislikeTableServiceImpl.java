package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.DislikeTable;
import com.sovava.video.service.DislikeTableService;
import com.sovava.video.dao.DislikeTableMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【dislike_table(点踩)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class DislikeTableServiceImpl extends ServiceImpl<DislikeTableMapper, DislikeTable>
    implements DislikeTableService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DislikeTable> page = this.page(
                new Query<DislikeTable>().getPage(params),
                new QueryWrapper<DislikeTable>()
        );

        return new PageUtils(page);

    }
}




