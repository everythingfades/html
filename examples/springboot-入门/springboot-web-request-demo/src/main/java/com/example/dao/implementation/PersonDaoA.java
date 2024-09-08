package com.example.dao.implementation;

import java.util.List;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.dao.PersonDao;
import com.example.pojo.Person;
import com.example.utils.XMLParser;

// @Component
@Repository
public class PersonDaoA implements PersonDao{

  @Override
  public List<Person> listPerson(){
    String file = "src/main/resources/data.xml";
    List<Person> list = XMLParser.parse(file, Person.class);
    return list;
  }
}
