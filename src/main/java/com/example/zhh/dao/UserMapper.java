package com.example.zhh.dao;

import com.example.zhh.pojo.User;

import java.util.List;

//@CacheConfig(cacheNames = "user")
public interface UserMapper {
//    @Cacheable()
    public List<User> queryUserList();

    User findByUserName(String userName);
}
