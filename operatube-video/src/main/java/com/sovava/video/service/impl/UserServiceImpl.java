package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.User;
import com.sovava.video.service.UserService;
import com.sovava.video.dao.UserMapper;
import com.sovava.video.service.VerifyCodeService;
import com.sovava.video.vo.LoginDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* @author root
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private VerifyCodeService verifyCodeService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<User> page = this.page(
                new Query<User>().getPage(params),
                new QueryWrapper<User>()
        );

        return new PageUtils(page);

    }

    @Override
    public User login(LoginDetailVo loginDetailVo, HttpServletRequest request, HttpServletResponse response) {
        verifyCodeService.verify(request.getSession().getId(), loginDetailVo.getVerifyCode());

        return null;
    }
}




