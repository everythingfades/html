package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
  private Integer code;
  private String msg;
  private Object data;
  // public Result(){

  // }
  // public Result(Integer code, String msg, Object data){
  //   this.code = code;
  //   this.msg = msg;
  //   this.data = data;
  // }
  // public Integer getCode() {
  //   return code;
  // }
  // public String getMsg() {
  //   return msg;
  // }
  // public Object getData() {
  //   return data;
  // }
  public static Result success(Object data){
    return new Result(1, "success", data);
  }

  public static Result success(){
    return new Result(1, "success", null);
  }

  public static Result error(){
    return new Result(1, "error", null);
  }

  public static Result error(Object data){
    return new Result(1, "error", data);
  }

  @Override
  public String toString() {
    return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
  }
  
}
