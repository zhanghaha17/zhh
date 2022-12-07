package com.example.zhh.service.impl;

import com.example.zhh.dao.UserMongoDao;
import com.example.zhh.pojo.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMongoImpl {
    @Autowired
    private UserMongoDao userMongoDao;

    public List<UserMongo> getAllUser(){
        return userMongoDao.findAll();
    }

    public void saveUser(UserMongo userMongo){
        userMongo.setId(null);
        userMongoDao.save(userMongo);
    }
}
