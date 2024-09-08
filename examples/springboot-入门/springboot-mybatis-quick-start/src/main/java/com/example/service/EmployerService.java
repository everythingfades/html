package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.pojo.Employer;
import com.example.pojo.PageBean;

public interface EmployerService {

  public void delete(Integer id);

  public List<Employer> listAllEmployers();

  public List<Employer> listAllEmployersWithPage();

  public List<Employer> list(String name, Short gender, LocalDate begin, LocalDate end);
  // public List<Employer> list(EmployerRequest request);

  public PageBean page(Integer page, Integer pageSize);

  public PageBean pageConditional(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
  
  public void newEmployer(Employer employer);
}