package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.entity.Category;
import com.sovava.video.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category/tree")
    public R getCategoryWithTree(@RequestParam(required = false) Integer categoryId) {
        if (categoryId == null) {
            List<Category> categoryWithTree = categoryService.getCategoryWithTree();
            return R.ok().setData(categoryWithTree);
        }
        Category category = categoryService.getCategoryById(categoryId);

        if (category.getFatherId() == 0) {
            return R.ok().setData(category);
        } else {
            Category category1 = categoryService.getCategoryById(category.getFatherId());
            return R.ok().setData(category1);
        }
    }
}
