package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Category;
import com.sovava.video.entity.Comment;
import com.sovava.video.service.CommentService;
import com.sovava.video.dao.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Comment> page = this.page(
                new Query<Comment>().getPage(params),
                new QueryWrapper<Comment>()
        );

        return new PageUtils(page);

    }
}




