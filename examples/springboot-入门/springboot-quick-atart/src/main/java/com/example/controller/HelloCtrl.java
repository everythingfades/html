package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
// 请求处理类
import org.springframework.web.bind.annotation.RestController;

// 

@RestController
public class HelloCtrl {
  @RequestMapping("/hello")
  public String hello(){
    System.out.println("Hello World");
    return "Hello World";
  }
}