package com.springboot.demo.threadpool;

import ch.qos.logback.classic.util.LoggerNameUtil;
import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredField;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program demo
 * @description: 线程池执行原理,创建
 * @author: qitengjie
 * @create: 2024-04-16 16:54
 */
public class TestThreadPoolExecutor {
    static class MyTask implements Runnable{
        private final String name;
        private final long duration;

        public MyTask(String name){
            this(name,0);
        }

        public MyTask(String name,long duration){
            this.name = name;
            this.duration = duration;
        }

        @Override
        public void run() {
            try {
//                LoggerUtils.get("myThread").debug("running..."+this);
                System.out.println(Thread.currentThread().getName()+" running...."+this);
                Thread.sleep(duration);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger(1);

        //强制有界队列      底层数组  Node需要提前创建好   一把锁(锁全部)
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);

        //默认无界，支持有界 底层链表  入队会生成新Node     两把锁(头尾，锁入队和出队；相对于数组队列，LinkedBlockingDeque效率较高)
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        /**
         * 线程池参数1.核心线程数量 2。最大线程数量，
         * 3。救急线程存活时间（最大减去核心线程数量 为救急线程）
         * 4。队列
         * 5。线程工厂
         * 6。拒绝策略
         *
         * 执行原理：首先判断 "核心线程是否已满"
         * 否：添加到工作线程并执行 ；
         * 是： 进行下一步，
         *
         * 判断 "阻塞队列是否已满"
         * 否：添加任务到阻塞队列
         * 是：进行下一步
         *
         * 判断"线程数量（当前线程+运行中的线程）是否小于最大线程"
         * 否：执行拒绝策略处理
         * 是：创建非核心线程执行任务（救急线程）
         *
         * 核心线程或者救急线程执行完之后， 会去判断队列中是否有线程排队，有则执行队列中的线程
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                3,
                0,
                TimeUnit.MILLISECONDS,
                queue,
                r -> new Thread(r,"myThread"+c.getAndIncrement()),
                new ThreadPoolExecutor.AbortPolicy());

        showState(queue,threadPool);
        threadPool.submit(new MyTask("1",3600000));
        showState(queue,threadPool);
        threadPool.submit(new MyTask("2",3600000));
        showState(queue,threadPool);

        threadPool.submit(new MyTask("3"));
        showState(queue,threadPool);
        threadPool.submit(new MyTask("4"));
        showState(queue,threadPool);

        threadPool.submit(new MyTask("5",3600000));
        showState(queue,threadPool);

        threadPool.submit(new MyTask("6"));
        showState(queue,threadPool);


    }

    private static void showState(ArrayBlockingQueue<Runnable> queue,ThreadPoolExecutor threadPool){
        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        List<Object> tasks = new ArrayList<>();
        for (Runnable runnable : queue) {
            try {
                Field callable = FutureTask.class.getDeclaredField("callable");
                callable.setAccessible(true);
                Object adapter = callable.get(runnable);
                Class<?> aClazz = Class.forName("java.util.concurrent.Executors$RunnableAdapter");
                Field task = aClazz.getDeclaredField("task");
                task.setAccessible(true);
                Object o = task.get(adapter);
                tasks.add(o);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("pool size:"+threadPool.getPoolSize()+",queue:"+tasks);
    }
}
