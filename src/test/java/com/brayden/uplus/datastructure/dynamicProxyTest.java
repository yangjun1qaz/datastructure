package com.brayden.uplus.datastructure;

import com.brayden.uplus.datastructure.proxy.dynamic.MyTransaction1;
import com.brayden.uplus.datastructure.proxy.dynamic.PersonService;
import com.brayden.uplus.datastructure.proxy.dynamic.PersonServiceImpl;
import com.brayden.uplus.datastructure.proxy.dynamic.PersonServiceInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class dynamicProxyTest {


    @Test
    public void contextdyLoads() {
        //目标类
        Object target = new PersonServiceImpl();
        //增强类
        MyTransaction1 myTransaction1 = new MyTransaction1();
        PersonServiceInterceptor personServiceInterceptor = new PersonServiceInterceptor(target, myTransaction1);
        PersonService personService = (PersonService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), personServiceInterceptor);
        String person = personService.createPerson();
        System.out.println(person);
    }
}
