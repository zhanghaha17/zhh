package com.example.zhh.controller;





public abstract class ARunnable {

    
    public ARunnable(){
        
    }
    private static int a = 11;
   protected abstract void test();
}

class K extends ARunnable{
    public static void main(String[] args) {
        ARunnable aRunnable = new ARunnable() {
            @Override
            protected void test() {
                System.out.println("666");
            }
        };
        aRunnable.test();
        new K().test();
    }

    @Override
    protected void test() {
        System.out.println("777");
    }
}
