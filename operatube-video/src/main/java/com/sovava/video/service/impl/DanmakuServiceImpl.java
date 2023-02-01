package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.Danmaku;
import com.sovava.video.service.DanmakuService;
import com.sovava.video.dao.DanmakuMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【danmaku(弹幕表)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class DanmakuServiceImpl extends ServiceImpl<DanmakuMapper, Danmaku>
    implements DanmakuService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Danmaku> page = this.page(
                new Query<Danmaku>().getPage(params),
                new QueryWrapper<Danmaku>()
        );

        return new PageUtils(page);

    }
}




