package com.brayden.uplus.datastructure.proxy.cglib;

import org.springframework.stereotype.Component;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@Component
public class MyTransaction2 {

    public String startTransaction() {
        System.out.println("开启事务");
        return "开启事务";
    }

    public String endTransaction() {
        System.out.println("关闭事务");
        return "关闭事务";
    }
}
