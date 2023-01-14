package com.sovava.video.dao;

import com.sovava.video.entity.Danmaku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author root
* @description 针对表【danmaku(弹幕表)】的数据库操作Mapper
* @createDate 2023-01-13 22:17:14
* @Entity com.sovava.video.entity.Danmaku
*/
@Mapper
public interface DanmakuMapper extends BaseMapper<Danmaku> {

}




