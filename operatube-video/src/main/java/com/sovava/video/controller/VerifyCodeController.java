package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.service.VerifyCodeService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.image.ByteArrayImageSource;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class VerifyCodeController {

    @Resource
    private VerifyCodeService verifyCodeService;
    private static final String format = "png";

    @GetMapping("/api/verifyImage")
    public HttpEntity image(HttpSession session) throws IOException {
        Image image = verifyCodeService.image(session.getId());
        InputStreamResource inputStreamResource = imageToInputStreamResource(image);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Pragma", "No-cache");
        headers.set("Cache-Control", "no-cache");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentType(MediaType.IMAGE_PNG)
                .body(inputStreamResource);

    }


    private static InputStreamResource imageToInputStreamResource(Image image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, format, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return new InputStreamResource(byteArrayInputStream);
    }
}
