package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups ="stu")
public class GroupsOnClass1 {

    public  void stu1(){
        System.out.println("GroupsOnClass1中的stu111111方法的运行！!!!");
    }
    public  void stu2(){
        System.out.println("GroupsOnClass1中的stu222222方法的运行！!!!");
    }
}
