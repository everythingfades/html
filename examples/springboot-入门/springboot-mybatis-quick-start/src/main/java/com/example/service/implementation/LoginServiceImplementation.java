package com.example.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.LoginMapper;
import com.example.pojo.Employer;
import com.example.service.LoginService;


@Service
public class LoginServiceImplementation implements LoginService{

  @Autowired
  public LoginMapper loginMapper;

  @Override
  public Employer login(Employer employer) {
    List<Employer> emps = loginMapper.login(employer);
    if (emps.size() == 0){
      return null;
    }
    else if (emps.size() > 1){
      return null;
    }
    return emps.get(0);
  }

}
