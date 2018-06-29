package com.course;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * Created by zsm on 2018/6/29.
 */

@SpringBootApplication
@Slf4j
@EnableScheduling
public class Application {

    private  static ConfigurableApplicationContext  context;
    public  static  void  main(String[] args){

        Application.context = SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    //预存储的方法
    public  void close(){
        Application.context.close();

    }
}
