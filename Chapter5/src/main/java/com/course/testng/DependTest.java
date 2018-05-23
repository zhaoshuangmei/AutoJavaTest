package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
//    依赖测试test2依赖 test 1 ，test1运行后test2运行， test1抛出异常后 test2 不会运行,前面是后面的前置条件
    @Test
    public  void test1(){
        System.out.println("test1 run !!!");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    public  void  test2(){
        System.out.println("test 2 run !!");
    }

}
