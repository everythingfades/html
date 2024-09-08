package com.example.service.implementation;

import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.EmployerMapper;
import com.example.pojo.Employer;
import com.example.pojo.PageBean;
import com.example.service.EmployerService;

@Service
public class EmployerServiceImplementation 
implements EmployerService{
  @Autowired
  private EmployerMapper empMapper;

  @Override
  public void delete(Integer id) {
    empMapper.delete(id);
  }

  @Override
  public List<Employer> listAllEmployers() {
    return empMapper.listAllEmployers();
  }

  @Override
  public List<Employer> listAllEmployersWithPage() {
    return empMapper.listAllEmployers();
  }

  @Override
  public List<Employer> list(String name, Short gender, LocalDate begin, LocalDate end) {
    return empMapper.list(name, gender, begin, end);
  }
  // public List<Employer> list(EmployerRequest request) {
  //   return empMapper.list(request);
  // }

  @Override
  public PageBean page(Integer page, Integer pageSize) {
    Long count = empMapper.countAllEmployers();
    List<Employer> result = empMapper.page((page-1)*pageSize, pageSize);
    PageBean pageBean = new PageBean(count, result);
    return pageBean;
  }

  @Override
  public PageBean pageConditional(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,
      LocalDate end) {
    Long count = empMapper.countAllEmployersConditional(name, gender, begin, end);
    List<Employer> result = empMapper.pageConditional((page-1)*pageSize, pageSize, name, gender, begin, end);
    PageBean pageBean = new PageBean(count, result);
    return pageBean;
  }

  @Override
  public void newEmployer(Employer employer) {
    empMapper.newEmployer(employer);
  }
}
