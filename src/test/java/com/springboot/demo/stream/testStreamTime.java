package com.springboot.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program accumulative
 * @description:测试stream处理耗时
 * @author: jason.qi
 * @create: 2019-12-04 20:33
 */
public class testStreamTime {
    @Test
    public void mess(){

        tttttt(1000);


    }

    public void tttttt(int num) {

        List<Employ> employs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Employ employ = new Employ();
            employ.setAge(11);
            employ.setName("zhangsan");
            employs.add(employ);
        }
        Long start = System.currentTimeMillis();

        for (Employ employ : employs) {
            System.out.println(employ.age);
        }
        Long end = System.currentTimeMillis();
        Long forTime = (end-start);
        System.out.println("for循环耗时->"+forTime);

        employs.stream().forEach(emp->{
            System.out.println(emp.age);
        });
        Long streamTime = (System.currentTimeMillis()-end);
        System.out.println("stream().forEach循环耗时->"+streamTime);
        end = System.currentTimeMillis();

        employs.parallelStream().forEach(employ -> {
            System.out.println(employ.age);
        });
        Long parallelStream = (System.currentTimeMillis()-end);
        System.out.println("parallelStream().forEach循环耗时->"+parallelStream);
        if (streamTime<forTime){
            System.out.println("num->"+num);
            return;
        }else {
            tttttt(num+1);
        }
    }

    class Employ{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employ{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
