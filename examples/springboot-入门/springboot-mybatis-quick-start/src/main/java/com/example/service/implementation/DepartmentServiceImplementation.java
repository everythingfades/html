package com.example.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.mapper.DepartmentMapper;
import com.example.pojo.Department;
import com.example.service.DepartmentService;

@Service
public class DepartmentServiceImplementation 
implements DepartmentService{
  @Autowired
  private DepartmentMapper deptMapper;

  /**  
   * 查询全部部门
   */
  @Override
  public List<Department> list() {
    return deptMapper.list();
  }

  @Override
  public void delete(Integer id) {
    deptMapper.deleteById(id);
  }

  @Override
  public void add(Department dept) {
    dept.setCreatedTime(LocalDateTime.now());
    dept.setAlteredTime(LocalDateTime.now());
    deptMapper.insert(dept);
  }

  @Override
  public void edit(Department dept) {
    dept.setAlteredTime(LocalDateTime.now());
    deptMapper.editDept(dept);
  }

  @Override
  public List<Department> listDeptById(Integer id) {
    return deptMapper.listDeptById(id);
  }
}
