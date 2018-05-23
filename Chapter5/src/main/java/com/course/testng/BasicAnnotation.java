package com.course.testng;
import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注释，用来把方法标记为测试的一部分
    //快捷键 alt+回车 调用引进那个maven包
    @Test
    public void TestCase1(){
        System.out.println("TestCase1这是测试用例1");
    }
    @Test
    public  void TestCase2(){
        System.out.println("TestCase2这是测试用例2");
    }
    //在每一次方法运行前BeforeMethod  AfterMethod  都会运行
    @BeforeMethod
    public void  beforeMethod(){
        System.out.println("BeforeMethod这是在测试用例之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试用例之后运行的");
    }
    //在类正式运行前是不是需要，是不是需要注册一些对象，静态变量，静态方法 变量赋值 其他的method就可以用了
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforClass这是在类运行之前运行的方法");
    }
    @AfterClass
    public  void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的方法");
    }
//    suite把class包在里面，里面可以包含多个class，在class运行之前
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    public  void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
