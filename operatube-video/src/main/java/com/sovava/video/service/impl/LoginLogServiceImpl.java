package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.LoginLog;
import com.sovava.video.service.LoginLogService;
import com.sovava.video.dao.LoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【login_log】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog>
    implements LoginLogService{

}




