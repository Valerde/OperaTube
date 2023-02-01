package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.entity.Category;
import com.sovava.video.exception.UserNotFoundException;
import com.sovava.video.service.ArticleService;
import com.sovava.video.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @Resource
    private CategoryService categoryService;

    @GetMapping("getAll")
    public R getAll() {
        List<Category> list = categoryService.list();
        return R.ok().setData(list);
    }

    @GetMapping("/home/list")
    public R getHomeArticleList(@RequestParam Map<String,Object> paramMap){
        return R.ok().setData(articleService.queryPage(paramMap));
    }
}
