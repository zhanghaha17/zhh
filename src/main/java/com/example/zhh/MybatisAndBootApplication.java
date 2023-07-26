package com.example.zhh;

import com.example.zhh.component.ApplicationValue;
import com.example.zhh.component.CustumeValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableConfigurationProperties({ApplicationValue.class, CustumeValue.class})
@SpringBootApplication
@EnableCaching
@EnableAsync
public class MybatisAndBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAndBootApplication.class, args);
	}

}
