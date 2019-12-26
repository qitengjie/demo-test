package com.springboot.demo.java8;

/**
 * @program demo-test
 * @description: 实现
 * @author: jason.qi
 * @create: 2019-10-03 21:17
 */
public class ComputeImpl implements Compute {

    @Override
    public Integer minus(Integer x, Integer y) {
        return x-y;
    }

    public static void main(String[] args) {
        Compute compute = new ComputeImpl();
        System.out.println(compute.add(2,1));
        System.out.println(compute.minus(22,1));
        Compute.test();
    }

}
