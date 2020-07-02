package com.brayden.uplus.datastructure;

import com.brayden.uplus.datastructure.proxy.staticproxy.PersonProxyServiceImpl;
import com.brayden.uplus.datastructure.proxy.staticproxy.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticProxyTest {

    @Resource
    PersonProxyServiceImpl proxyService;

    @Test
    public void contextLoads() {
        proxyService.createPerson();
    }
}
