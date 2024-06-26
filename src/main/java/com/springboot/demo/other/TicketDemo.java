package com.springboot.demo.other;

/**
 * @program demo
 * @description: 抢票
 * @author: qitengjie
 * @create: 2024-04-15 14:03
 */
public class TicketDemo {
    static Object lock = new Object();
    int ticketNum = 10;
    public void getTicket(){
        synchronized(lock){
            if (ticketNum<=0){
                return;
            }
            System.out.println(Thread.currentThread().getName()+"抢到一张票,剩余："+ticketNum);
            //非原子性操作
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();
        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                ticketDemo.getTicket();
            }).start();
        }
    }
}
