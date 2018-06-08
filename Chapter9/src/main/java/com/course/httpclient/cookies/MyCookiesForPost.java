package com.course.httpclient.cookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforetest() {
        //默认识别properties后缀文件、相对resourse的相对路径,字符编码配置local.CHINa
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String Result;
        //从配置文件中，拼接到测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
//        HttpGet  get  = new HttpGet(this.url+bundle.getString("getCookiesurl"));
        //测试逻辑代码书写 HttpClient本身没有获取cookie信息，defaultHttpClient
        HttpGet get = new HttpGet(testUrl);
//        HttpClient client = new DefaultHttpClient();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse respose = client.execute(get);
        Result = EntityUtils.toString(respose.getEntity(), "utf-8");
        System.out.println(Result);

        //获取cookies信息
//        CookieStore store = client.getCookieStore();
        this.store = client.getCookieStore();
        List<Cookie> cookieslist = store.getCookies();
        for (Cookie cookie : cookieslist) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name  = " + name + " ; cookie value =" + value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public  void  testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        //拼接最终的测试地址
        String testUri = this.url + uri;
        //声明一个Client对象，用来进行方法的执行
        DefaultHttpClient  client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUri);
        //添加参数
        JSONObject  param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息,设置header
        post.setHeader("content-type","application/json");
        //经参数信息添加到方法中
        StringEntity  entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象，来进行响应结果result的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取相应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //处理结果，判断结果是否符合预期
//        将返回的响应结果字符串转化为json对象
        JSONObject  resultjosn =  new JSONObject(result);
//        具体的判断返回的结果值
        String success = (String) resultjosn.get("huhansan");
        String status =  (String) resultjosn.get("status");
        //获取到具体的结果值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}



