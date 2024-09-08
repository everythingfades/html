package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Result;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@RestController
public class SessionController {

  // 设置Cookie
  @GetMapping("/cookie/c1")
  public Result cookie1(HttpServletResponse response) {
    response.addCookie(new Cookie("login_username", "example"));
    return Result.success();
  }
  
  // 获取Cookie
  @GetMapping("/cookis/c2")
  public String cookie2(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie: cookies){
      if (cookie.getName().equals("example")){
        System.out.println("登录用户名" + cookie.getValue());
      }
    }
    return new String();
  }

  @GetMapping("/s1")
  public Result session1(HttpSession session) {
    log.info("HttpSession-s1: {}", session.hashCode());
    session.setAttribute("loginUser", "tom");
    return Result.success();
  }
  
  @GetMapping("/s2")
  public Result session2(HttpServletRequest request) {
    HttpSession session = request.getSession();
    log.info("HttpSession-s2: {}", session.hashCode());

    Object loginUser = session.getAttribute("loginUser"); // 从session中获取数据
    log.info("loginUser: {}", loginUser);

    return Result.success(loginUser);
  }
  
}
