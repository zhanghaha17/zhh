package com.example.zhh.service.impl;

import com.example.zhh.pojo.SysLog;
import com.example.zhh.service.SysLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class SysLogDaoImp implements SysLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveSysLog(SysLog syslog) {


        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(syslog));
    }
    @Async(value = "asyncThreadPoolTaskExecutor")
    @Override
    public Future<Integer> testAsync() {
        System.out.println("当前线程名称：：："+Thread.currentThread().getName());
//        SysLog sysLog = new SysLog();
//        sysLog.setCreateTime(new Date(System.currentTimeMillis()));
//        sysLog.setIp("127.0.0.1");
//        sysLog.setMethod("put");
//        sysLog.setOperation("update");
//        sysLog.setParams("object");
//        sysLog.setTime(0);
//        sysLog.setUsername("lfqlfq");
//        saveSysLog(sysLog);

        Map<String, Object>[] array = new HashMap[100];
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        String sql = "insert into sys_log(id,username,time) values(:id,:username,:time)";

        for(int i = 0;i<100;i++){
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("id",i*123);
            stringObjectHashMap.put("username",i+"xuxu");
            stringObjectHashMap.put("time",i);
            array[i] = stringObjectHashMap;
        }

        npjt.batchUpdate(sql,array);
        return new AsyncResult<>(123);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
