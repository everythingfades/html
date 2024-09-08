package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select;
// import org.springframework.beans.factory.annotation.Autowired;

import com.example.pojo.Employer;

@Mapper
public interface LoginMapper {


  public List<Employer> login(Employer employer);
  
}