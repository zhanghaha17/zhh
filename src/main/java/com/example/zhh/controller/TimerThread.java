package com.example.zhh.controller;

import com.example.zhh.dao.TTaishiMapper;
import com.example.zhh.pojo.TTaishi;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Component
public class TimerThread extends TimerTask {

    @Resource
    private TTaishiMapper tTaishiMapper;

    public static TimerThread testUtil;

    @PostConstruct
    public void init() {
        testUtil = this;
        testUtil.tTaishiMapper = this.tTaishiMapper;
    }


    Date startDate = new Date();
    private Timer timer = new Timer();

    public void start(){
        timer.schedule(this,startDate,1000);
    }

    @Override
    public void run() {
        TTaishi tTaishi = new TTaishi();
        tTaishi.setId(UUID.randomUUID().toString());
        tTaishi.setTime(new Date());
        Random random = new Random();
        tTaishi.setValue(String.valueOf(random.nextInt(2)));
        testUtil.tTaishiMapper.insert(tTaishi);
    }
}
