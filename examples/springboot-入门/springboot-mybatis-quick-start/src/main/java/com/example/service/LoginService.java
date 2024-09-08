package com.example.service;

import org.springframework.stereotype.Service;

import com.example.pojo.Employer;

@Service
public interface LoginService {
  public Employer login(Employer employer);
}
