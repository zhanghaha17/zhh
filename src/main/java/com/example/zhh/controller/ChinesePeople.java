package com.example.zhh.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChinesePeople extends People{
    public void print(){
        System.out.println("I am a Chinese");
    }
    public void skin(){
        System.out.println("I have yellow skin !" );
    }

    public static void main(String[] args) {
        People p = new People();
        ChinesePeople cp = (ChinesePeople)p;
        p.print();
        ExecutorService executorService = Executors.newCachedThreadPool();

    }
}
