package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Person;
import com.example.pojo.Result;
import com.example.service.PersonSevice;
// import com.example.service.implementation.PersonServiceA;

@RestController
@CrossOrigin
public class EmpController {

  @Qualifier("personServiceA")
  @Autowired
  private PersonSevice personSevice;

  @RequestMapping("/ListPerson")
  public Result list(){
    List<Person> list = personSevice.ListPerson();
    return Result.success(list);
  }
}
