package com.springboot.demo.threadpool;

/**
 * @program demo
 * @description: CPU核数
 * @author: qitengjie
 * @create: 2024-04-17 09:59
 */
public class ProcessorsDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        /** Java &、&&、|、||、^、<<、>>、~、>>>等运算符
         * 如何确定核心线程数量
         * 并发不高、任务执行时间长
         * 1。IO密集型的任务（一般来说：文件读写、DB读写、网络请求等）  CPU核数*2+1
         * 2。计算密集型任务 （计算型代码、Bitmap转换、Gson转换等） CPU核数+1
         */


    }
}
