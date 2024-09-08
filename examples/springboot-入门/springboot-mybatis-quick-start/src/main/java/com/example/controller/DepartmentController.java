package com.example.controller;

// import java.time.LocalDate;
import java.time.LocalDateTime;
// import java.util.List;

// import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Department;
import com.example.pojo.Result;
import com.example.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;






@Slf4j
// 加了注解就可以直接调用Logger
@RequestMapping("/dept")
@CrossOrigin
@RestController
public class DepartmentController {

  @Autowired
  private DepartmentService deptService;
  // @RequestMapping(value="/listDept", method=RequestMethod.GET)
  @GetMapping("/listDept")
  public Result listDept(){
    // List<Employer> employerList = employerMapper.list(name, gender, begin, end);
    log.info("查询所有部门");
    return Result.success(deptService.list());
  }

  @DeleteMapping("/deleteDept/{id}")
  public Result deleteDeptById(@PathVariable Integer id){
    log.info("根据id删除部门");
    deptService.delete(id);
    return Result.success();
  }

  @PostMapping("/newDept")
  public Result add(@RequestBody Department dept) {
      deptService.add(dept);
      return Result.success();
  }
  
  @GetMapping("/listDept/{id}")
  public Result listDeptById(@PathVariable Integer id) {
      return Result.success(deptService.listDeptById(id));
  }
  
  @PutMapping("/editDept/{id}")
  public Result editDept(@PathVariable Integer id, String name) {
      Department dept = deptService.listDeptById(id).get(0);
      dept.setAlteredTime(LocalDateTime.now());
      dept.setName(name);
      deptService.edit(dept);
      return Result.success();
  }
}
