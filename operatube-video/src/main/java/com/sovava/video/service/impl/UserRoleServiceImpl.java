package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.UserRole;
import com.sovava.video.service.UserRoleService;
import com.sovava.video.dao.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




