package com.example.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
// import org.apache.ibatis.annotations.Result;
// import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.pojo.Employer;


@Mapper
public interface EmployerMapper {

  @Delete("delete from employers where id = #{id}")
  public void delete(Integer id);

  @Options(keyProperty = "id", useGeneratedKeys = true)
  @Insert("""
INSERT INTO employers(username, name, gender, image, job, entrydate, dept_id, created_time, altered_time) VALUES
(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createdTime},#{alteredTime})""")
  public void insert(Employer employer);

  @Update("update employers set username=#{username}, name=#{name}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, altered_time=#{alteredTime} where id=#{id};")
  public void update(Employer employer);

  
  // @Select("SELECT id,username, password, name, gender, image, job, entrydate, dept_id as deptId, altered_time as alteredTime, created_time as createdTime from employers WHERE id = #{id}")
  // public Employer getById(Integer id);

  // @Results({
  //   @Result(column="dept_id", property = "deptId"),
  //   @Result(column="created_time", property = "createdTime"),
  //   @Result(column="altered_time", property = "alteredTime")
  // })
  // @Select("SELECT id,username, password, name, gender, image, job, entrydate, dept_id as deptId, altered_time, created_time from employers WHERE id = #{id}")
  // public Employer getById(Integer id);

  @Select("SELECT id,username, password, name, gender, image, job, entrydate, dept_id as deptId, altered_time, created_time from employers WHERE id = #{id}")
  public Employer getById(Integer id);

  // @Select("Select * from employers WHERE name LIKE '%${name}%' AND gender = #{gender} AND entrydate BETWEEN #{begin} AND #{end} ORDER BY altered_time;")
  // public List<Employer> list(String name, Short gender, LocalDate begin, LocalDate end);
  public List<Employer> list(String name, Short gender, LocalDate begin, LocalDate end);

  public void deleteByIds(List<Integer> ids);

  public List<Employer> listAllEmployers();

  public List<Employer> page(Integer start, Integer pageSize);

  public List<Employer> pageConditional(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

  public Long countAllEmployers();

  public Long countAllEmployersConditional(String name, Short gender, LocalDate begin, LocalDate end);

  public void newEmployer(Employer employer);
}
