package com.sovava.video.service;

import com.sovava.common.utils.PageUtils;
import com.sovava.video.entity.Notification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author root
* @description 针对表【notification(通知表)】的数据库操作Service
* @createDate 2023-01-13 22:17:14
*/
public interface NotificationService extends IService<Notification> {
    PageUtils queryPage(Map<String, Object> params);
}
