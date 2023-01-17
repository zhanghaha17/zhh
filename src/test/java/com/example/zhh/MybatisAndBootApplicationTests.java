package com.example.zhh;


import com.example.zhh.dao.TRoleMapper;
import com.example.zhh.dao.UserMapper;
import com.example.zhh.pojo.TRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisAndBootApplicationTests {
	public MybatisAndBootApplicationTests() {
	}

	@Resource
	private UserMapper userMapper;
	@Resource
	private TRoleMapper tRoleMapper;

	@Test
	public void contextLoads() {
//		User mrbird = userMapper.findByUserName("mrbird");
//		System.out.println(mrbird.toString());
//
//		List<TRole> polePer = tRoleMapper.getPolePer("2");
//		System.out.println("xixi"+polePer.size());

		List<TRole> rolePer2 = tRoleMapper.getPolePer("1");
		System.out.println("xixi"+rolePer2.toString());
	}

}
