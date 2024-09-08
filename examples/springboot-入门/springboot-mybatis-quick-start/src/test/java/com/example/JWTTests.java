package com.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// @SpringBootTest
// 加了这个注释会加载整个spring环境,如果test和spring无关可以去掉这个注释
public class JWTTests {

  @Test
  public void testGenJwt(){
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", 1);
    claims.put("name", "Tom");
    String jwt = Jwts.builder()
      .signWith(SignatureAlgorithm.HS256,"example") // 设置签名算法
      .setClaims(claims) // 设置数据
      .setExpiration(new Date(System.currentTimeMillis() + 3600*1000)) // 设置有效时间
      .compact(); // 转为字符串
    System.out.println(jwt);
  }

  @Test
  public void testParseJwt(){
    Claims claims = Jwts.parser()
      .setSigningKey("example") // 设置秘钥
      .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcyNTQ0NjE2OH0.1Nc2PM8RLNPnwYAf8lYCGeqQII-hAf4-Hf75Ofhls2I")
      .getBody();
    System.out.println(claims);
  }
}
