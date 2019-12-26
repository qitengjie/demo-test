package com.springboot.demo.java8;

/**
 * @program demo-test
 * @description: 一、接口的默认方法和静态方法
 * @author: jason.qi
 * @create: 2019-10-03 21:15
 */
public interface Compute {
    default Integer add(Integer x,Integer y){
        return x+y;
    }
    Integer minus(Integer x,Integer y);

    static void test(){
        System.out.println("static method test()");
    }

}
