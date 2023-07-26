package com.example.zhh.handle;

import com.example.zhh.handle.impl.MyImpl;

public class TestInvocation {

    int a = 10;

    public static void test(){
        System.out.println("hahha");
    }

    public static void main(String[] args) {
        MyImpl my = new MyImpl();
        MyInvocationHandle myInvocationHandle = new MyInvocationHandle();
        myInvocationHandle.setTarger(my);
        MyInterface proxy = (MyInterface)myInvocationHandle.getProxy();
        proxy.eat("aa");
        proxy.sleep("bb");
    }


}

class chi extends TestInvocation{
    int a = 22;
    public static void main(String[] args){
        System.out.println("wawawa");



        new chi().main();
        new chi().aaa();
    }
    public void aaa(){
        System.out.println("wawawa"+(++this.a));
    }

    public int main(){
        this.a = 99;
        return 0;
    }
}
