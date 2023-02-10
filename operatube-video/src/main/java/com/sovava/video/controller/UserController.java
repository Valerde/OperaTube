package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.entity.User;
import com.sovava.video.service.UserService;
import com.sovava.video.vo.LoginDetailVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/api/register")
    public R userRegister() {
        return null;
    }

    @GetMapping("/api/login")
    public R userLogin(LoginDetailVo loginDetailVo, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.login(loginDetailVo, request, response);

        return R.ok().setData(user);
    }

    @GetMapping("/api/logout")
    public R userLogout() {
        return null;
    }

}
