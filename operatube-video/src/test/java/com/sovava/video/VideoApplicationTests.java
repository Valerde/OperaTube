package com.sovava.video;

import com.sovava.video.entity.Category;
import com.sovava.video.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class VideoApplicationTests {

    @Resource
    private CategoryService categoryService;

    @Test
    void contextLoads() {
        List<Category> list = categoryService.list();
        log.debug("种类数据是：{}", list.toString());
    }

}
