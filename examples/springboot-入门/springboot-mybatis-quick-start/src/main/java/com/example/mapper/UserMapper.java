package com.example.mapper;

import com.example.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper//运行的时候框架会自动生成实现类对象,然后交给IOC管理
public interface UserMapper {

  @Select("select * from users")
  public List<User> list();
}
