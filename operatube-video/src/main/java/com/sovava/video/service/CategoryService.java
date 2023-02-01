package com.sovava.video.service;

import com.sovava.common.utils.PageUtils;
import com.sovava.video.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author root
* @description 针对表【category】的数据库操作Service
* @createDate 2023-01-13 22:17:14
*/
public interface CategoryService extends IService<Category> {
    PageUtils queryPage(Map<String, Object> params);

    List<Category> getCategoryWithTree();

    Category getCategoryById(Integer categoryId);

}
