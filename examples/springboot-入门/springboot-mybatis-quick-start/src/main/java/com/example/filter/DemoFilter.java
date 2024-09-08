package com.example.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*") // 配置拦截所有url
public class DemoFilter implements Filter{

  @Override // 新建类.执行一次
  public void init(FilterConfig filterconfig) throws ServletException{
    // Filter.super.init(filterconfig);
    System.out.println("init");
  }

  @Override //过滤,执行多次
  public void doFilter(
    ServletRequest request,
    ServletResponse response,
    FilterChain chain
    ) throws IOException, ServletException{
    // System.out.println("doFilter");
    // 放行
    chain.doFilter(request, response);
  }

  @Override
  public void destroy(){ // 销毁,只执行一次
    System.out.println("destroy");
    // Filter.super.destroy();
  }

}
