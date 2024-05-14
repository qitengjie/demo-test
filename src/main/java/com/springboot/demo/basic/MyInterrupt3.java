package com.springboot.demo.basic;

/**
 * @program demo
 * @description:停止一个正在运行的线程 interrupt
 * @author: qitengjie
 * @create: 2024-04-15 12:42
 */
public class MyInterrupt3 {
    public static void main(String[] args) throws InterruptedException {
        //1.打断阻塞的线程
        /*Thread t1 = new Thread(() -> {
            System.out.println("t1 正在运行....");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        System.out.println(t1.isInterrupted());*/
        //2.打断正常的线程 interrupt默认false， 调用interrupt()之后变为true
        Thread t2 = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if (interrupted){
                    System.out.println("打断状态："+interrupted);
                    break;
                }
            }
        },"t2");
        t2.start();
        Thread.sleep(500);
        t2.interrupt();

    }
}
