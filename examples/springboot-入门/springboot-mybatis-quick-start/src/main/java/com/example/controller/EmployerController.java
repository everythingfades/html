package com.example.controller;

import java.time.LocalDate;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employer;
import com.example.pojo.PageBean;
// import com.example.mapper.EmployerMapper;
// import com.example.pojo.Employer;
import com.example.pojo.Result;
import com.example.service.EmployerService;

import lombok.extern.slf4j.Slf4j;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@Slf4j
@CrossOrigin
@RequestMapping("/employer")
@RestController
public class EmployerController {
  @Autowired
  private EmployerService empService;

  @GetMapping("/listEmployers")
  public Result listEmployers(){
    log.info("查询所有员工");
    return Result.success(empService.listAllEmployers());
  }

  @GetMapping("/listEmployersWithPage")
  public Result list(
    @RequestParam(defaultValue = "1") Integer page,
    @RequestParam(defaultValue = "10") Integer pageSize
    ) {
      log.info("分页查询,参数{},{}",page,pageSize);
      PageBean pageBean = empService.page(page, pageSize);
      return Result.success(pageBean);
  }

  @GetMapping("/listEmployersConditionalWithPage")
  public Result listConditional(
    @RequestParam(defaultValue = "1") Integer page,
    @RequestParam(defaultValue = "10") Integer pageSize,
    String name,
    Short gender,
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
      log.info("分页查询,参数{},{}",page,pageSize);
      PageBean pageBean = empService.pageConditional(page, pageSize, name, gender, begin, end);
      return Result.success(pageBean);
  }
  
  @DeleteMapping("/deleteEmployer/{id}")
  public Result deleteEmployer(@PathVariable Integer id){
    empService.delete(id);
    return Result.success();
  }

  @PutMapping("/newEmployer")
  public Result newEmployer(@RequestBody Employer employer) {
    empService.newEmployer(employer);
    return Result.success();
  }
}
