package com.brayden.uplus.datastructure.unionfind;

/**
 * bing
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/14
 */
public interface UF {

    /**
     * 元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 元素p跟元素q是否连接
     *
     * @param p
     * @param q
     * @return
     */
    Boolean isConnection(int p, int q) throws Exception;

    /**
     * 元素p 跟元素q 连接在一起
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q) throws Exception;
}
