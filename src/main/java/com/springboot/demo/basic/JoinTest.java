package com.springboot.demo.basic;

/**
 * @program demo
 * @description: 等待线程运行结束
 * @author: qitengjie
 * @create: 2024-04-15 11:44
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("t1");
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        });

        t1.start();
        t2.start();
        t3.start();



    }
}
