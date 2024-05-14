package com.springboot.demo.javabase;

/**
 * @program demo
 * @description: 单例
 * @author: qitengjie
 * @create: 2022-05-17 14:05
 */
public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if (null == singleton){
            synchronized (Singleton.class){
                if (null == singleton){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
