package com.example.zhh;

import com.example.zhh.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackageClasses = {UserMapper.class})
@SpringBootApplication
public class MybatisAndBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAndBootApplication.class, args);
	}

}
