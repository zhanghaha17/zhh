package com.example.zhh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.zhh.dao")
@SpringBootApplication
public class MybatisAndBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAndBootApplication.class, args);
	}

}
