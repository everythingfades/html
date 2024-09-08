package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pojo.Department;

@Service
public interface DepartmentService {

  /**
   * 返回所有部门
   */
  public List<Department> list();

  /**
   * 根据id返回部门
   * @return
   */
  public List<Department> listDeptById(Integer id);

  /**
   * 根据id删除部门
   */
  public void delete(Integer id);

  /**
   * 新增部门
   */
  public void add(Department dept);

  /**
   * 编辑部门
   */
  public void edit(Department dept);
} 