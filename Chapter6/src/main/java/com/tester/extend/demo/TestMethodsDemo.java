package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);

    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);

    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");

    }
    @Test
    public  void logDmeo(){
        Reporter.log("这是我们自己的写的log");
        throw  new RuntimeException("这是我们自己运行时抛的异常");
    }
}
