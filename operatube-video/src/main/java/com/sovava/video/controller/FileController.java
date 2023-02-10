package com.sovava.video.controller;

import com.sovava.common.utils.R;
import com.sovava.video.repository.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {

    @javax.annotation.Resource
    private FileService fileService;

    @GetMapping("/upload/video")
    public R saveVideo(@RequestParam(value = "file[]")MultipartFile file, HttpServletRequest request){

    }


    /**
     * 这是播视频的核心代码，先从请求路径中找到视频，接着在数据库中查找，文件信息
     *
     * @param date
     * @param filename
     * @param key
     * @param request
     * @return
     */


    @GetMapping("/download")
    public ResponseEntity getSrc(HttpServletRequest request) {
        try {
            Path file = fileService.loadFile("test.MP4");
            Resource resource = new UrlResource(file.toUri());
            HttpHeaders headers = new HttpHeaders();
            String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);
            return ResponseEntity.
                    status(HttpStatus.OK).
                    headers(headers).
                    body(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
