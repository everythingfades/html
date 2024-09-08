package com.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pojo.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  // 补货所有异常
  public Result ex(Exception ex){
    ex.printStackTrace();;
    return Result.error("操作失败");
  }
}
