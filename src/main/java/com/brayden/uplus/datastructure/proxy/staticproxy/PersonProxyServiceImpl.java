package com.brayden.uplus.datastructure.proxy.staticproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 代理类
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@Service
public class PersonProxyServiceImpl implements PersonService {

    @Resource
    PersonService personService;

    @Autowired
    MyTransaction myTransaction;

    @Override
    public void createPerson() {
        myTransaction.startTransaction();
        personService.createPerson();
        myTransaction.endTransaction();
    }

    @Override
    public void updatePerson() {
        myTransaction.startTransaction();
        personService.updatePerson();
        myTransaction.endTransaction();
    }

    @Override
    public void delPerson() {
        myTransaction.startTransaction();
        personService.delPerson();
        myTransaction.endTransaction();
    }
}
