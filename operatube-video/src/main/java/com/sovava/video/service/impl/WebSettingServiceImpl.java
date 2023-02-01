package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.WebSetting;
import com.sovava.video.service.WebSettingService;
import com.sovava.video.dao.WebSettingMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【web_setting】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class WebSettingServiceImpl extends ServiceImpl<WebSettingMapper, WebSetting>
    implements WebSettingService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebSetting> page = this.page(
                new Query<WebSetting>().getPage(params),
                new QueryWrapper<WebSetting>()
        );

        return new PageUtils(page);

    }
}




