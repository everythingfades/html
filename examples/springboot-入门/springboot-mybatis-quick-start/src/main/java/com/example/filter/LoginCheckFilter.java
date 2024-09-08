package com.example.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @WebFilter("/*")
public class LoginCheckFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 获取请求url
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    String url = req.getRequestURL().toString();
    log.info("访问url: {}", url);

    // 判断是否是登录请求
    if (url.contains("login")){
      log.info("登录操作,放行");
      chain.doFilter(request, response);
      return;
    }

    // 获取令牌
    String jwt = req.getHeader("Authorization");
    log.info("接收到jwt令牌 {}", jwt);
    // 判断令牌是否合法
    log.info("{}",StringUtils.hasLength(jwt));
    if (!StringUtils.hasLength(jwt)){
      log.info("请求头为空,未登录");
      Result error = Result.error("NOT_LOGIN");
      // 手动转json,在拦截器中还没有接收成json
      String notLogin = JSONObject.toJSONString(error);
      resp.getWriter().write(notLogin);
      return;
    }
    // 校验jwt令牌
    try{
      JwtUtils.parseJwt(jwt);
    }
    catch(Exception e){
      log.info("解析令牌失败");
      Result error = Result.error("NOT_LOGIN");
      // 手动转json,在拦截器中还没有接收成json
      String notLogin = JSONObject.toJSONString(error);
      resp.getWriter().write(notLogin);
      return;
    }

    // 放行
    log.info("令牌合法,放行");
    chain.doFilter(request, response);
  }


}
