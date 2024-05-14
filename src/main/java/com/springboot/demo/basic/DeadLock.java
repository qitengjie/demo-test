package com.springboot.demo.basic;

/**
 * @program demo
 * @description: 死锁
 * @author: qitengjie
 * @create: 2024-04-16 16:01
 */
public class DeadLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        Thread t1=new Thread(()->{
            synchronized (A){
                System.out.println(Thread.currentThread().getName()+"-lock A");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                synchronized (B){
                    System.out.println(Thread.currentThread().getName()+"-lock B");
                    System.out.println(Thread.currentThread().getName()+"-操作...");
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (B){
                System.out.println(Thread.currentThread().getName()+"-lock B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (A){
                    System.out.println(Thread.currentThread().getName()+"-lock A");
                    System.out.println(Thread.currentThread().getName()+"-操作...");
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
