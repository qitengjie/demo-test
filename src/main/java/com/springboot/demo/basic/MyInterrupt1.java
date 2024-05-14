package com.springboot.demo.basic;

/**
 * @program demo
 * @description: 停止一个正在运行的线程
 * @author: qitengjie
 * @create: 2024-04-15 12:21
 */
public class MyInterrupt1 extends Thread{
    volatile boolean flag = false;//线程执行的退出标志

    @Override
    public void run(){
        while (!flag){
            System.out.println("myThread ....run...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建MyThread对象
        MyInterrupt1 t1 = new MyInterrupt1();
        t1.start();


        //主线程休眠6秒
        Thread.sleep(6000);
        t1.flag=true;
    }
}
