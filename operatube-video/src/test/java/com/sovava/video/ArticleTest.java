package com.sovava.video;

import com.sovava.common.utils.PageUtils;
import com.sovava.video.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    void testArticlePage(){
        Map<String, Object> map = new HashMap<>();
//        map.put("page",1);
//        map.put("limit",24);
        PageUtils pageUtils = articleService.queryPage(map);
        log.debug("首页的数据为：{}",pageUtils.toString());
    }

}
