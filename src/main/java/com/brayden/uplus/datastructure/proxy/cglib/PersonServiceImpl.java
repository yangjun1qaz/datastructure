package com.brayden.uplus.datastructure.proxy.cglib;

/**
 * 业务类
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */

public class PersonServiceImpl implements PersonService {
    @Override
    public String createPerson() {
        System.out.println("保存用户信息");
        return "保存用户信息";
    }

    @Override
    public String updatePerson() {
        System.out.println("更新用户信息");
        return "更新用户信息";
    }

    @Override
    public String delPerson() {
        System.out.println("删除用户信息");
        return "删除用户信息";
    }
}
