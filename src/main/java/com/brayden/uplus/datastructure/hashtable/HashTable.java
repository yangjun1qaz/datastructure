package com.brayden.uplus.datastructure.hashtable;

import java.util.TreeMap;

/**
 * 哈希表
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/25
 */
public class HashTable<K, V> {

    /**
     * 哈希碰撞的上限
     * upperTotal=size/M
     */
    public static final int upperTotal = 10;
    /**
     * 哈写碰撞的下限
     * upperTotal=size/M
     */
    public static final int lowTotal = 2;
    /**
     * 初始容量
     */
    public static final int initCapacity = 7;
    /**
     * 哈希表
     */
    private TreeMap<K, V>[] hashtable;
    /**
     * 需要开辟的空间
     */
    private int M;
    /**
     * hashtable大小
     */
    private int size;


    public HashTable(int M) {
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    /**
     * 哈希函数
     * <p>
     * key.hashCode()&0x7fffffff  去掉负号
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 新增一个
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[key.hashCode()];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= upperTotal * M) {
                resize(2 * M);
            }
        }
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashtable[key.hashCode()];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size <= lowTotal * M && M / 2 > initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    /**
     * 改
     */
    public void set(K key, V value) throws Exception {
        TreeMap<K, V> map = hashtable[key.hashCode()];
        if (!map.containsKey(key)) {
            throw new Exception("current key not exist");
        }
        map.put(key, value);
    }

    /**
     * 查
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return hashtable[key.hashCode()].get(key);
    }

    /**
     * 动态扩容缩容
     *
     * @param newM
     */
    private void resize(int newM) {
        TreeMap[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<K, V>();
        }
        //是因为下面移动元素的时候要重新根据key算hashcode
        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            for (K key : hashtable[i].keySet()) {
                newHashTable[key.hashCode()].put(key, hashtable[i].get(key));
            }
        }
        hashtable = newHashTable;
    }
}
