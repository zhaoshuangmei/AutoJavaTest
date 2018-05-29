package com.course.testng.paramter;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    //默认线程池是1 ，线程池改成3 就是3个线程
    @Test(invocationCount = 10,threadPoolSize = 3)
    public  void test(){
        //线程的执行的顺序不一样，到print 1 一个线程
        //因为多线程的程序，执行效率不一样，各不相干，不挨着，不要有跨线程的关联,否则要加锁
        System.out.println("1");
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }
}
