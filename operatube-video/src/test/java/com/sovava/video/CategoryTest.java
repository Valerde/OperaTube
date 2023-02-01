package com.sovava.video;

import com.sovava.video.entity.Category;
import com.sovava.video.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class CategoryTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void testCategory() {
        List<Category> categoryWithTree = categoryService.getCategoryWithTree();
        log.debug("树形：{}", categoryWithTree.toString());

        Category categoryById = categoryService.getCategoryById(4);
        log.debug("ID查询{}", categoryById.toString());

    }
}
