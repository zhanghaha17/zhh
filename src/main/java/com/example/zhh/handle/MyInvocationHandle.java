package com.example.zhh.handle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandle implements InvocationHandler {

    private Object targer;

    public void setTarger(Object targer){
        this.targer = targer;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(getClass().getClassLoader(),targer.getClass().getInterfaces(),this);
    }

    public void wash(Method method){
        System.out.println("开始执行，且方法名称是_"+method.getName());
    }

    public void end(Method method){
        System.out.println("执行结束——"+method.getName());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        wash(method);
        System.out.println("args"+args[0]);
        method.invoke(targer,args);
        end(method);
        return null;
    }

}
