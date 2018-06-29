package com.course.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.log4j.Log4j;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsm on 2018/6/29.
 */
@RestController
@Log4j
//写日志
@Api(value = "v1",description ="这是我的第一个版本的value" )
@RequestMapping(value = "v1")
public class Demo {
    //首先获取一个执行sql语句的对象

    //@Autowired就是说启动级加载，我们把demo类启动起来，private SqlSessionTemplate Template;就被加载进来
//    private SqlSessionTemplate Template;

//    private  SqlSessionTemplate template;

    @Autowired
    private   SqlSessionTemplate  template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUsercount");
    }

}
