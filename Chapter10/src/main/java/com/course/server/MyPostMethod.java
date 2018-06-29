package com.course.server;


import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/V1")  //下面方法的所有url必须携带v1
public class MyPostMethod {
    //这个变量是用来装我们的cookies信息的
    private  static Cookie cookie;
    //用户登陆成功获取到cookies,然后在访问其他接口获取到列表，cookie加载到里面就可以访问了
//    @RequestParam(value = "UserNmae"（调用的时候显示的名字）,required = true) String UserName,==》和前端名字可以不对应

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value ="登录接口，成功后获取cookies信息",httpMethod = "POST")
    public  String login(HttpServletResponse response,
                          @RequestParam(value = "UserName",required = true) String UserName,
                         @RequestParam(value = "PassWord",required = true) String PassWord){
        if(UserName.equals("zhangsan") && PassWord.equals("123456")){

            cookie= new Cookie("login","true");
            response.addCookie(cookie);
            return  "恭喜你登录成功了！";

        }
        return  "用户名或密码错误！！！";

    }
    //如何验证cookies,如果验证通过了就把用户列表返回去
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod ="POST" )
    public String  GetUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookie是否合法
        for(Cookie c : cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassWord().equals("123456")){
                user= new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return  user.toString();
            }

        }
        return  "参数不合法";
    }
}
