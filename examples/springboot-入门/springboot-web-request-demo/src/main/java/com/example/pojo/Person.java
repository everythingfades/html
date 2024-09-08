package com.example.pojo;

public class Person {
  private String name;
  private Integer age;
  private String gender;
  private String type;
  public Person(String name, Integer age, String gender, String type) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.type = type;
  }
  public String getName() {
    return name;
  }
  public Integer getAge() {
    return age;
  }
  public String getGender() {
    return gender;
  }
  public String getType() {
    return type;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void setType(String type) {
    this.type = type;
  }
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", type=" + type + "]";
  }
  
}
