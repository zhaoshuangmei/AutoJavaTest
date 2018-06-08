package com.course.httpclient.cookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

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
    public  void  TestGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUri = this.url + uri;
        HttpGet get = new HttpGet(testUri);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse  response = client.execute(get);
        //获取响应的状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        System.out.println("statuscode :" + StatusCode);
        if(StatusCode == 200){
           String  Result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(Result);
        }
    }
}
