package com.sovava.video.dao;

import com.sovava.video.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author root
* @description 针对表【article(视频，图片，文章 发帖表

TODO 回复消息可见，加密帖子，视频等)】的数据库操作Mapper
* @createDate 2023-01-13 22:17:14
* @Entity com.sovava.video.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




