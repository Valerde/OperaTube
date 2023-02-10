package com.sovava.video.service.impl;

import com.sovava.video.service.VerifyCodeService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Override
    public void verify(String key, String code) {

    }

    @Override
    public Image image(String id) {
        return null;
    }
}
