package com.springboot.demo.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program demo
 * @description: List去除重复
 * @author: qitengjie
 * @create: 2023-08-20 21:57
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("1111");
        listStr.add("1111");
        listStr.add("2222");
        listStr.add("3333");
        listStr.add("3333");

        removeDuplicate2(listStr);
    }

    public static void removeDuplicate1(List list) {
        for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {
            for ( int j = list.size() - 1 ; j > i; j -- ) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }

    public static void removeDuplicate2(List list) {
        HashSet hashSet = new HashSet<>(list);
        list.clear();
        list.addAll(hashSet);
        System.out.println(list);
    }




}
