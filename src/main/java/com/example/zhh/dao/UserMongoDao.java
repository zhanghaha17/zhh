package com.example.zhh.dao;

import com.example.zhh.pojo.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoDao extends MongoRepository<UserMongo,String> {
}
