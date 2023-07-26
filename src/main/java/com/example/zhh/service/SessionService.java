package com.example.zhh.service;

import com.example.zhh.pojo.UserOnline;

import java.util.List;


public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
