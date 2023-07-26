package com.example.zhh.service;

import com.example.zhh.pojo.SysLog;

import java.util.concurrent.Future;


public interface SysLogDao {

    void saveSysLog(SysLog syslog);

    Future<Integer> testAsync();
}
