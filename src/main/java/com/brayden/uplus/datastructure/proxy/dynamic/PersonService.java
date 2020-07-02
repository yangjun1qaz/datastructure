package com.brayden.uplus.datastructure.proxy.dynamic;

/**
 * 代理的本质是：对目标方法的增强
 * <p>
 * 静态代理的弊端：
 * <p>
 * 1、静态代理是对某一个类去做代理，假如有100个server，要写100个代理类。
 * 2、一个server中如果方法过多（需要增强），产生大量的冗余代码
 * <p>
 * 面试阐述这个例子（类型日志、事务）
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/2
 */
public interface PersonService {

    public String createPerson();

    public String updatePerson();

    public String delPerson();
}
