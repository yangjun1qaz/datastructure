package com.brayden.uplus.datastructure.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
public class PersonServiceInterceptorCGLIB implements MethodInterceptor {

    //目标类
    private Object target;

    //增强类
    private MyTransaction2 myTransaction2;

    public PersonServiceInterceptorCGLIB(Object target, MyTransaction2 myTransaction2) {
        this.target = target;
        this.myTransaction2 = myTransaction2;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.myTransaction2.startTransaction();
        Object invoke = method.invoke(target, objects);
        this.myTransaction2.endTransaction();
        return null;
    }
}
