package com.springboot.demo.basic;

/**
 * @program demo
 * @description: 可见性例子 1.禁用即时编译器-Xint 2
 * @author: qitengjie
 * @create: 2024-04-15 19:03
 */
public class ForeverLoop {
    volatile static boolean stop = false;

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop=true;
            System.out.println(Thread.currentThread().getName()+"modify stop to true");
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+stop);
        },"t2").start();

        new Thread(()->{
            int i=0;
            while (!stop){
                i++;
            }
            System.out.println("stoped....c:"+i);
        },"t3").start();
    }
}
