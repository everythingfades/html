package com.example.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;

// @WebFilter("/*")
public class ABCFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // System.out.println("ABC 拦截到了请求,放行前");
    chain.doFilter(request, response);
    // System.out.println("ABC放行后");
  }

}
