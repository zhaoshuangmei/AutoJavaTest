package com.course.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut=3000) //单位为毫秒值
    public void TestSuceess() throws  InterruptedException{
        Thread.sleep(2000);


    }
    @Test(timeOut=2000)
    public  void TestFail() throws InterruptedException{
        Thread.sleep(3000);
    }


}
