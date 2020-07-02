package com.brayden.uplus.datastructure.proxy.staticproxy;

import org.springframework.stereotype.Service;

/**
 * 业务类
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public void createPerson() {
        System.out.println("保存用户信息");
    }

    @Override
    public void updatePerson() {
        System.out.println("更新用户信息");
    }

    @Override
    public void delPerson() {
        System.out.println("删除用户信息");
    }
}
