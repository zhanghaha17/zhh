package com.example.zhh.handle.impl;

import com.example.zhh.handle.MyInterface;

public class MyImpl implements MyInterface {
    @Override
    public void eat(String a) {
        System.out.println("吃饭中");
    }

    @Override
    public void sleep(String a) {
        System.out.println("睡觉中");
    }
}
