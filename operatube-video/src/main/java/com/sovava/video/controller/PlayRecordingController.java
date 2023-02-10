package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.service.PlayRecordingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class PlayRecordingController {

    @Resource
    private PlayRecordingService playRecordingService;


    @GetMapping("/api/user/playrecording/list")
    public R getUserPlayRecordingList(@RequestParam Map<String, Object> param, HttpServletRequest request) {
        return null;
    }
}
