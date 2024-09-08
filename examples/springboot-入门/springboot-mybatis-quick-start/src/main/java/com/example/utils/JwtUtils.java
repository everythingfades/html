package com.example.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtUtils {
  private static String signKey = "example";
  private static Long expire = 43200000L;

  public static String generateJwt(Map<String, Object> claims){
    String jwt = Jwts.builder()
      .signWith(SignatureAlgorithm.HS256,"example") // 设置签名算法
      .setClaims(claims) // 设置数据
      .setExpiration(new Date(System.currentTimeMillis() + expire)) // 设置有效时间
      .compact(); // 转为字符串
    return jwt;
  }

  public static Claims parseJwt(String jwt){
    try{
      Claims claims = Jwts.parser()
        .setSigningKey("example") // 设置秘钥
        .parseClaimsJws(jwt)
        .getBody();
      return claims;
    }
    catch (Exception e) {
      return null;
    }
  }
}
