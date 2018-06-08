package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/V1")
public class MyPostMethod {
    //这个变量是用来装我们的cookies信息的
    private  static Cookie cookie;
    //用户登陆成功获取到cookies,然后在访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value ="登录接口，成功后获取cookies信息",httpMethod = "POST")
    public  String login(HttpServletResponse response,
                         @RequestParam(value = "UserNmaae",required = true) String UserName,
                         @RequestParam(value = "PassWord",required = true) String PassWord){
        if(UserName.equals("zhangsan") && PassWord.equals("123456")){

            cookie= new Cookie("login","true");
            response.addCookie(cookie);
            return  "恭喜你登录成功了！";

        }
        return  "用户名或密码错误！！！";

    }
//    //如何验证cookies,如果验证通过了就把用户列表返回去
//    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
//    @ApiOperation(value = "获取用户列表",httpMethod ="POST" )
//    public User GetUserList(HttpServletRequest request,
//                            @ResponseBody User u){
//        //获取cookies
//        Cookie[] cookies = request.getCookies();
//        //验证cookie是否合法
//        for(Cookie c : cookies){
//            if(c.getName()=="login"
//                    && c.getValue()=="ture"
//                    && u.getUsertname()=="zhng"){
//
//            }
//
//        }
//
//    }
}
