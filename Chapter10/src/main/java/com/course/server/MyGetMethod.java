package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//如何给客户端返回cookie的接口
@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取cookies",httpMethod ="GET" )
    public  String getCookies(HttpServletResponse resonse){
        //HttpServerletRequest  装请求的信息类 不是参数，
        //HttpServerletResponse  装响应的信息类
        Cookie cookie = new Cookie("login", "true");
        resonse.addCookie(cookie);
        return "恭喜你获得cookies信息成功---";
    }
/**
 * 要求客户端携带cookie访问
 * 这是一个需要携带cookie信息才能访问的get请求
 * 接口访问成功，验证不通过，客户端需带着真确的信息来访问
 */
@RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
@ApiOperation(value = "要求客户端携带cookie访问",httpMethod = "GET")
public  String  GetWithCookies(HttpServletRequest  request){
    Cookie[] cookies = request.getCookies();   //cookis数组
    if(Objects.isNull(cookies)){
        return  "你必须携带cookies信息来----1";

    }
    for(Cookie cookie:cookies){
        if(cookie.getName().equals("login")  &&
                cookie.getValue().equals("true")){
            return  "恭喜你访问成功----这是一个需要携带cookie信息才能访问的get请求";
        }
    }

    return  "你必须携带cookies信息来";

}
/**
 * 开发一个需要携带参数才能访问的的get请求
 * 第一种实现方式 url:key=value && key= value
 * 我们来模拟获取商品的列表 泛型
 *
 */
@RequestMapping(value = "/getwithparam",method = RequestMethod.GET)
@ApiOperation(value ="这是客户端需要携带参数的第一种方法实现",httpMethod = "GET")
public Map<String,Integer> getlist(@RequestParam Integer start,
                                   @RequestParam Integer end){
    //商品列表
    Map< String,Integer> mylist = new HashMap<>();
    //start 和end 去数据库中取数据
    mylist.put("鞋",400);
    mylist.put("干脆面",1);
    mylist.put("衬衫",300);
    return  mylist;


}
/**
 * 第二种需要携带参数访问的get请求
 * url:ip:port/get/with/param/10/20
 */
@RequestMapping(value = "/getwithparam/{start}/{end}")
@ApiOperation(value ="这是客户端需要携带参数的第二种方法实现",httpMethod = "GET")
public  Map myGetList(@PathVariable Integer start,
                      @PathVariable Integer end){

    //商品列表
    Map< String,Integer> mylist = new HashMap<>();
    //start 和end 去数据库中取数据
    mylist.put("鞋",400);
    mylist.put("干脆面",1);
    mylist.put("衬衫",300);
    return  mylist;

}
}

