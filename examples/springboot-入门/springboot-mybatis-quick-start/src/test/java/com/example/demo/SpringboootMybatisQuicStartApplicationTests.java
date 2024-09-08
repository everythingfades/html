package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.EmployerMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Employer;
import com.example.pojo.User;

@SpringBootTest /// 整合测试的注解
class SpringboootMybatisQuicStartApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EmployerMapper employerMapper;

	@Test
	public void contextLoads() {
		List<User> userList = userMapper.list();
		System.out.print("printing output\n");
		for (User a: userList){
			System.out.println(a);
		}
	}

	@Test
	public void testJdbc() throws Exception {
		// 指定要用的sql driver
		// 1. 注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. 获取连接对象
		String url = "jdbc:mysql://localhost:3306/db05";
		String username = "root";
		String password = "123456";
		Connection connection = DriverManager.getConnection(url, username, password);

		// 3.获取执行SQL的对象Statement,执行SQL,返回结果
		String sql =  "select * from users";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		// 4.封装结果数据
		List<User> userList = new ArrayList<>();
		while (resultSet.next()){
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			short age = resultSet.getShort("age");
			short gender = resultSet.getShort("gender");
			String phone = resultSet.getString("phone");

			User user = new User(id, name, age, gender, phone);
			userList.add(user);
		}
		
		// 5. 释放资源
		statement.close();
		connection.close();

		for (User a: userList){
			System.out.println(a);
		}
	}
	@Test
	public void testDelete() {
		employerMapper.delete(17);
	}
	
	@Test
	public void testInsert() {
		Employer employer = new Employer();
		employer.setUsername("张三2");
		employer.setName("zhangsan");
		employer.setImage("1.jpg");
		employer.setGender((short)1);
		employer.setJob((short)1);
		employer.setEntrydate(LocalDate.of(2018, 1, 1));
		employer.setCreatedTime(LocalDateTime.now());
		employer.setAlteredTime(LocalDateTime.now());
		employerMapper.insert(employer);
		System.out.println(employer.getId());
		// 这个不能获取
		System.out.println(employer.getName());
		// 这个可以获取
	}

	@Test
	public void testUpdate() {
		Employer employer = new Employer();
		employer.setId(10);
		employer.setUsername("李四");
		employer.setName("lisi");
		employer.setImage("4.jpg");
		employer.setGender((short)1);
		employer.setJob((short)1);
		employer.setEntrydate(LocalDate.of(2018, 1, 1));
		employer.setAlteredTime(LocalDateTime.now());
		employerMapper.update(employer);
	}

	@Test
	public void testGetById(){
		Employer employer = employerMapper.getById(20);
		System.out.println(employer);
	}

	// @Test
	// public void testGetList(){
	// 	// List<Employer> employerList = employerMapper.list("zhang", (short)1, LocalDate.of(2010,1,1), LocalDate.of(2020,1,1));
	// 	List<Employer> employerList = employerMapper.list(null, (short) 1, null, null);
	// 	System.out.println(employerList);
	// }

	@Test
	public void testDeleteByIds(){
		List<Integer> ids = Arrays.asList(13,14,15);
		employerMapper.deleteByIds(ids);
	}
}
