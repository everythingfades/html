package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // filter 不是springboot里的组件需要额外引入
@SpringBootApplication
public class SpringbootMybatisQuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisQuickStartApplication.class, args);
	}

}
