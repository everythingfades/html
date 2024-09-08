package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employer;
import com.example.pojo.Result;
import com.example.service.LoginService;
import com.example.utils.JwtUtils;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.utils.JwtUtils;

@RestController
@Slf4j
@CrossOrigin
public class LoginController {

  @Autowired
  public LoginService loginService;


  @PostMapping("/login")
  public Result getMethodName(@RequestBody Employer employer) {
    log.info("员工登录 {}", employer);
    Employer emp = loginService.login(employer);
    if (emp != null){
      Map<String, Object> claims = new HashMap<>();

      claims.put("id", employer.getId());
      claims.put("name", employer.getName());
      claims.put("username", employer.getUsername());
      String jwt = JwtUtils.generateJwt(claims);
      return Result.success(jwt);
    }
    return Result.error("用户名或密码错误");
  }
  
  @PostMapping("/identifyJwt")
  public Result parseJwt(String jwt){
    Claims claims = JwtUtils.parseJwt(jwt);
    if (claims == null){
      log.info("登录失败");
      return Result.error();
    }
    log.info("登录成功");
    return Result.success(claims);
  }
}
