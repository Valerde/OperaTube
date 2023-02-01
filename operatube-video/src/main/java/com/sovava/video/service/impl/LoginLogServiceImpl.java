package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.LoginLog;
import com.sovava.video.service.LoginLogService;
import com.sovava.video.dao.LoginLogMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【login_log】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog>
    implements LoginLogService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginLog> page = this.page(
                new Query<LoginLog>().getPage(params),
                new QueryWrapper<LoginLog>()
        );

        return new PageUtils(page);

    }
}




