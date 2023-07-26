package com.example.zhh.handle;

public interface MyInterface {



    public void eat(String a);

    public abstract void sleep(String a);

//    default修饰也可以有方法体 java8以后才可以
    default public  void tes(){
        System.out.println(123);
    }
}
