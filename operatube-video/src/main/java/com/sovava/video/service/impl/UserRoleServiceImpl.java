package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.UserRole;
import com.sovava.video.service.UserRoleService;
import com.sovava.video.dao.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserRole> page = this.page(
                new Query<UserRole>().getPage(params),
                new QueryWrapper<UserRole>()
        );

        return new PageUtils(page);

    }
}




