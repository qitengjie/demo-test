package com.springboot.demo.jvm;

import java.util.ArrayList;

/**
 * @program demo
 * @description: 堆信息 命令：jps jstack jmap 可视化工具：Jconsole VisaulVM
 * 获取快照dump方式
 * 1：jmap命令
 * 2：VM参数-Xmx10m
 * -XX:+ HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/jason/Desktop/dumpFile/java_111.hprof
 * @author: qitengjie
 * @create: 2024-04-19 10:40
 */
public class ToolDemo {
    public static void main(String[] args) {
//        new Thread(()->{
//            while (true){
//
//            }
//        },"t1").start();
//
//        new Thread(()->{
//            while (true){
//
//            }
//        },"t2").start();
//
//        new Thread(()->{
//            while (true){
//
//            }
//        },"t3").start();

        ArrayList<String> objects = new ArrayList<>();
        while (true){
            objects.add("北京");
        }

    }
}
