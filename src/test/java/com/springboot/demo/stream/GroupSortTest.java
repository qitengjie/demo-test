package com.springboot.demo.stream;

import com.springboot.demo.Users;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program demo-test
 * @description: 分组和排序
 * @author: jason.qi
 * @create: 2019-09-04 22:44
 */
public class GroupSortTest {
    static List<Users> usersList = Arrays.asList(new Users("aaa","男",33,new Date()),
            new Users("bbb","男",33,new Date()),
            new Users("aaa","男",44,new Date()),
            new Users("ccc","男",33,new Date()),
            new Users("dddd","男",33,new Date())
    );
    //TODO 根据name分组，然后每组中根据年龄降序
    public static void main(String[] args) {

        //直接先排序再分组
        Map<String,List<Users>> stringListMap =usersList.stream().sorted((o1,o2)->o2.getAge().compareTo(o1.getAge())).collect(
                Collectors.groupingBy(Users::getName)
        );


//        for (Map.Entry<String,List<Users>> entry:stringListMap.entrySet()){
//            System.out.println("+++++++"+entry.getKey());
//            List<Users> users = entry.getValue();
//            users.stream().forEach(user-> System.out.println(user));
//        }
        System.out.println("遍历map开始......");
        stringListMap.forEach((k,v)->{
            System.out.println("k:"+k);
            System.out.println("v:"+v);
            System.out.println("-----------");
        });
        System.out.println("遍历map结束......");
    }

}
