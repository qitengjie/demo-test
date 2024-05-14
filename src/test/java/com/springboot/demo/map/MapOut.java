package com.springboot.demo.map;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program demo
 * @description: map输出方式
 * @author: qitengjie
 * @create: 2023-08-20 21:39
 */
public class MapOut {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","123456");
        map.put("2","222222");
        map.put("3","3333333");

        //1 使用普遍，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        map.keySet().forEach(k->{
            System.out.println("key="+k+" value="+map.get(k));
        });

        //2 通过entrySet 通过iterator遍历
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key="+next.getKey()+" value="+next.getValue());
        }

        //3 推荐使用 尤其大容量的时候
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println("key="+stringStringEntry.getKey()+ " value="+stringStringEntry.getValue());
        }

        //4 map.values遍历所有的value，但不能遍历key
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        map.values().forEach(value->{
            System.out.println("value="+value);
        });
    }


}
