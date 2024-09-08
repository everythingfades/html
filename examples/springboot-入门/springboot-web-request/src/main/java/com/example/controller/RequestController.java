package com.example.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
// javax.servlet 和 jakarta.servlet 是 Java Servlet API 的两个版本。
// 所以教程里用的是javax那个
// 大概是因为他用的java11, 我电脑上这个项目用的java17

@RestController
public class RequestController {

  @RequestMapping("/simpleParam")
  public String simpleParam(HttpServletRequest request){
    String name = request.getParameter("name");
    String ageStr = request.getParameter("age");
    int age = Integer.parseInt(ageStr);
    System.out.println(name + ":" + age);
    return "OK";
  }

  @RequestMapping("/simpleParam1")
  public String simpleParam1(@RequestParam(name="id") String username, Integer age){
      System.out.println(username + ":" + age);
      return "OK";
  }

  @RequestMapping("/simplePojo")
  public String simplePojo(User user){
    System.out.println(user);
    return "OK";
  }

  @RequestMapping("/complexPojo")
  public String complexPojo(User user){
    System.out.println(user);
    return "OK";
  }

  @RequestMapping("/simpleArray")
  public String simpleArray(String[] hobby){
    System.out.println(Arrays.toString(hobby));
    return "OK";
  }

  @RequestMapping("/simpleArray1")
  public String simpleArray1(@RequestParam List<String> hobby){
    System.out.println(hobby);
    return "OK";
  }

  @RequestMapping("/simpleDate")
  public String simpleDate(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
    System.out.println(updateTime);
    return "OK";
  }
  @RequestMapping("/simpleJson")
  public String simpleJson(@RequestBody User user){
    System.out.print(user);
    return "OK";
  }

  @RequestMapping("/path/{id}")
  public String simplePath(@PathVariable Integer id){
    System.out.println(id);
    return "OK";
  }

  @RequestMapping("/path/{id}/{content}")
  public String simplePath(@PathVariable Integer id, @PathVariable String content){
    System.out.println(id + ":" + content);
    return "OK";
  }
}
