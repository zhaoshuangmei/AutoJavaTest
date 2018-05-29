package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){

        System.out.println("name =" + name + "; age =" + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object [][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",11},
                {"wangwu",12}
        };

       return o;
    }


    //根据方法进行参数传递
    @Test(dataProvider = "methodData")
    public  void  test1(String name, int age){
        System.out.println("test1111 的方法 name" + name + "age="+ age);

    }
    @Test(dataProvider = "methodData")
    public  void  test2(String name, int age){
        System.out.println("test2222 的方法 name" + name + "age="+ age);

    }
    //后面的的method 回去拿上面的method name
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object [][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",13},
                    {"lisi",14},

            };
            }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"zhangsan",16},
                    {"lisi",17},

            };

        }

        return result;
    }
}
