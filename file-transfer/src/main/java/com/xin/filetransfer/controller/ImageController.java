package com.xin.filetransfer.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {

    @GetMapping("/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        // 读取图片资源
        Resource resource = new ClassPathResource("static/" + imageName);
        
        // 如果资源存在
        if (resource.exists()) {
            byte[] imageBytes = Files.readAllBytes(Paths.get(resource.getURI()));
            
            // 设置响应头，指定图片类型
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // 这里根据你的图片类型进行设置
            
            // 返回图片数据
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            // 图片资源不存在时，返回404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
