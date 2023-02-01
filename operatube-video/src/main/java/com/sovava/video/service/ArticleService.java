package com.sovava.video.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sovava.common.utils.PageUtils;
import com.sovava.video.entity.Article;

import java.util.Map;

/**
* @author root
* @description 针对表【article(视频，图片，文章 发帖表

TODO 回复消息可见，加密帖子，视频等)】的数据库操作Service
* @createDate 2023-01-13 22:17:14
*/
public interface ArticleService extends IService<Article> {
    PageUtils queryPage(Map<String, Object> params);
}
