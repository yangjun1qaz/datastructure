package com.brayden.uplus.datastructure.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
public class PersonServiceInterceptor implements InvocationHandler {

    //目标类
    private Object target;

    //增强类
    private MyTransaction1 myTransaction1;

    //构造函数注入目标类和增强类
    public PersonServiceInterceptor(Object target, MyTransaction1 myTransaction1) {
        this.target = target;
        this.myTransaction1 = myTransaction1;
    }


    //代理类的每一个方法被调用的时候都会调用下边的这个invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String resutl1 = this.myTransaction1.startTransaction();
        Object invoke = method.invoke(this.target, args);
        String result2 = this.myTransaction1.endTransaction();
        return resutl1+invoke+result2;
    }
}
