package com.test.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lvjing02 on 1/2/2018.
 * post请求
 * Jsoup的post请求只支持表单提交
 */
public class jsoupTestPost {
    public static void main(String[] args){
        System.out.println("------------------------------POST请求----------------------------------------");
        Connection conn = null;
        try {
            String url = "https://passport.jd.com/new/login.aspx";
            conn = Jsoup.connect(url);
            conn.data("loginname","test1");
            conn.data("loginpwd","test1");
            Document doc = conn.post();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------POST请求,带请求头----------------------------------------");
        try {
            String url = "https://passport.jd.com/new/login.aspx";
            conn = Jsoup.connect(url);
            conn.data("loginname","test1");
            conn.data("loginpwd","test1");

            //请求头设置，特别是cookie设置
            conn.header("Accept", "text/html, application/xhtml+xml, */*");
            conn.header("Content-Type", "application/x-www-form-urlencoded");
            conn.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
            conn.header("Cookie", "cookie");

            Document doc = conn.post();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------POST请求 获取响应码, 响应信息----------------------------------------");
        try {
            String url = "https://passport.jd.com/new/login.aspx";
            conn = Jsoup.connect(url);
            conn.data("loginname","test1");
            conn.data("loginpwd","test1");

            Connection.Response resp = conn.method(Connection.Method.GET).execute();
            //获取响应码
            int statusCode = resp.statusCode();
            System.out.println("响应码：" + statusCode);
            //获取主体,打印出响应的页面
            String body = resp.body();
            System.out.println("主体：：" + body);
            //获取所有cookies
            Map<String, String> cookies = resp.cookies();
            for(Map.Entry<String, String> cookie : cookies.entrySet()){
                System.out.println(cookie.getKey() + " : " + cookie.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
