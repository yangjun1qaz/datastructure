package com.brayden.uplus.datastructure;

import com.brayden.uplus.datastructure.proxy.cglib.MyTransaction2;
import com.brayden.uplus.datastructure.proxy.cglib.PersonServiceInterceptorCGLIB;
import com.brayden.uplus.datastructure.proxy.dynamic.PersonService;
import com.brayden.uplus.datastructure.proxy.dynamic.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CglibProxyTest {


    @Test
    public void contextdyLoads() {
        //目标类
        Object target = new PersonServiceImpl();
        //增强类
        MyTransaction2 myTransaction2 = new MyTransaction2();
        PersonServiceInterceptorCGLIB personServiceInterceptorCGLIB = new PersonServiceInterceptorCGLIB(target, myTransaction2);
        PersonService proxy = (PersonService) personServiceInterceptorCGLIB.createProxy();
        proxy.createPerson();
    }
}
