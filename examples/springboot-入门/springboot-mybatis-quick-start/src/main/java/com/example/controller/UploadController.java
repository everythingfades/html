package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pojo.Result;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class UploadController {

  @PostMapping("/upload")
  public Result upload(String username, Integer age, MultipartFile image) throws IllegalStateException, IOException {
      // log.info()
      log.info("文件上传:name:{},age:{},image:{}", username, age, image);
      String originalFilename = image.getOriginalFilename();
      int index = originalFilename.lastIndexOf(".");
      String suffix = originalFilename.substring(index);
      String newFilename = UUID.randomUUID() + suffix;
      image.transferTo(new File("D:\\Desktop\\" + newFilename));
      return Result.success();
  }
  

}
