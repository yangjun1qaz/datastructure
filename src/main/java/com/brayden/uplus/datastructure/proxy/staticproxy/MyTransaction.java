package com.brayden.uplus.datastructure.proxy.staticproxy;

import org.springframework.stereotype.Component;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
@Component
public class MyTransaction {

    public void startTransaction() {
        System.out.println("开启事务");
    }

    public void endTransaction() {
        System.out.println("关闭事务");
    }
}
