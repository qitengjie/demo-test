package com.springboot.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @program demo
 * @description:
 * @author: qitengjie
 * @create: 2022-05-14 18:17
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        Callable<String> task = new Callable<String>(){
            public String call(){
                System.out.println("Sleep start.");

                try {
                    Thread.sleep(1000*10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Sleep end.");
                return "time="+System.currentTimeMillis();
            }
        };

        //1.直接使用Thread 的方式执行
        FutureTask<String> ft = new FutureTask<String>(task);
        Thread t = new Thread(ft);
        t.start();

        try {
            System.out.println("waiting execute result");
            System.out.println("result = "+ft.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }


        //2.使用Executors来执行
//        FutureTask<String> ft2 = new FutureTask<String>(task);
//        Executors.newSingleThreadExecutor().submit(ft2);
//        try {
//            System.out.println("waiting execute result");
//            System.out.println("result = "+ft2.get());
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }catch (ExecutionException e){
//            e.printStackTrace();
//        }
    }
}
