package com.njq.study.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {
        /**
         * 实现LRU只需要设置accessOrder为true，重写缓存删除方法removeEldestEntry即可，
         * LinkedHashMap 是把新加入的和最新访问get的都放在链表尾部，链表头部就是最久未被访问的
         * accessOrder为false，就不做任何处理，按插入顺序有序
         * removeEldestEntry默认返回false，达到具体的长度就进行扩容， 如果返回了true则会进行删除链表头部的数据
         * jdk1.6 是使用addentry，createenrty等方法来实现LRU实现链表节点位置移动
         * jdk1.8进行了优化，它是重写了hashmap内部的几个方法来实现的
         * void afterNodeAccess(Node<K,V> p) { }
         * void afterNodeInsertion(boolean evict) { }
         * void afterNodeRemoval(Node<K,V> p) { }
         */
        LinkedHashMap<String, String> m = new LinkedHashMap(4, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 6;
            }
        };

        for (int i = 0; i < 10; i++) {
            m.put("aa" + i, i + "");
            if (i == 4) {
                //中途被访问了，它被移到的链表尾部
                m.get("aa1");
            }
        }

        for (Map.Entry entry : m.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
