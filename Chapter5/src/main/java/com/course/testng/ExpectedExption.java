package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedExption {

    /**
     * 什么时候会用到异常测试
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某些不合法的参数，程序出现了异常
     *也就是说我们的预期结果就是这个异常
     */
    //这是一个测试结果是会失败的测试
    @Test(expectedExceptions = RuntimeException.class)
    public  void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public  void  RunTimeExceptionSucces(){
        //注意这两行代码的顺序，抛出异常后后面的代码就运行不到了
        System.out.println("这是一个成功的测试用例");
        throw new RuntimeException();

    }


}
