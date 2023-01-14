package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.Comment;
import com.sovava.video.service.CommentService;
import com.sovava.video.dao.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




