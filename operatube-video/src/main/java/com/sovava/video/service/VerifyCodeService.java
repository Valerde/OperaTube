package com.sovava.video.service;

import java.awt.*;

public interface VerifyCodeService {


    void verify(String key,String code);

    Image image(String id);
}
