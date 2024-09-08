package com.example.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.pojo.Department;
@Mapper
public interface DepartmentMapper {

  @Select("SELECT * FROM department")
  // 由于语法比较简单于是放在这里,之后改成xml的格式
  List<Department> list();

  @Select("SELECT * FROM department Where id = #{id}")
  // 由于语法比较简单于是放在这里,之后改成xml的格式
  List<Department> listDeptById(Integer id);

  /** 
   * 根据id删除部门
  */
  @Delete("Delete From department Where id = #{id}")
  void deleteById(Integer id);

  @Insert("Insert Into department (name, created_time, altered_time) values (#{name}, #{createdTime}, #{alteredTime})")
  void insert(Department dept);

  @Update("update department set name=#{name} where id=#{id}")
  void editDept(Department dept);

  
}
