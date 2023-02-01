package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.Notification;
import com.sovava.video.service.NotificationService;
import com.sovava.video.dao.NotificationMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【notification(通知表)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification>
    implements NotificationService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Notification> page = this.page(
                new Query<Notification>().getPage(params),
                new QueryWrapper<Notification>()
        );

        return new PageUtils(page);

    }
}




