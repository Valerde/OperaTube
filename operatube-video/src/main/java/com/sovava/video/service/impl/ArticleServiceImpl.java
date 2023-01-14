package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.dao.ArticleMapper;
import com.sovava.video.entity.Article;
import com.sovava.video.service.ArticleService;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【article(视频，图片，文章 发帖表

TODO 回复消息可见，加密帖子，视频等)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{


}




