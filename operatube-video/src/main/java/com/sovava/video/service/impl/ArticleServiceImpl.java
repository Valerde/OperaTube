package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.dao.ArticleMapper;
import com.sovava.video.entity.Article;
import com.sovava.video.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【article(视频，图片，文章 发帖表

TODO 回复消息可见，加密帖子，视频等)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Article> page = this.page(
                new Query<Article>().getPage(params),
                new QueryWrapper<Article>()
        );

        return new PageUtils(page);
        //TODO: 添加其他信息
    }
}




