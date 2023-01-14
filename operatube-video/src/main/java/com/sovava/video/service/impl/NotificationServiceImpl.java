package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.Notification;
import com.sovava.video.service.NotificationService;
import com.sovava.video.dao.NotificationMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【notification(通知表)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification>
    implements NotificationService{

}




