package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.WebSetting;
import com.sovava.video.service.WebSettingService;
import com.sovava.video.dao.WebSettingMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【web_setting】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class WebSettingServiceImpl extends ServiceImpl<WebSettingMapper, WebSetting>
    implements WebSettingService{

}




