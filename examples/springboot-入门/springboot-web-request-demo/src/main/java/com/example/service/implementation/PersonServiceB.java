package com.example.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.PersonDao;
import com.example.pojo.Person;
import com.example.service.PersonSevice;

// @Component
@Primary
@Service
public class PersonServiceB implements PersonSevice {
  @Autowired
  private PersonDao personDao;
  @Override
  public List<Person> ListPerson() {
    List<Person> list = personDao.listPerson();
    // for (Person person: list){
    //   if (person.getType().equals("1")){
    //     person.setType("好人");
    //   }
    //   else if (person.getType().equals("2")){
    //     person.setType("坏人");
    //   }
    //   else {
    //     person.setType("不好不坏");
    //   }
    // }
    return list;
  }
}
