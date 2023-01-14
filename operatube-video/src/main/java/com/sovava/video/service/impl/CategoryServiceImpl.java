package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.Category;
import com.sovava.video.service.CategoryService;
import com.sovava.video.dao.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【category】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




