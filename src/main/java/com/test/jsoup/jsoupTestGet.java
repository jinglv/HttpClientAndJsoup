package com.test.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lvjing02 on 1/2/2018.
 * Get请求
 */
public class jsoupTestGet {
    public static void main(String[] args){
        String url = "https://www.cnblogs.com/nbkhic/";
        System.out.println("------------------------------Get请求----------------------------------------");
        //Get请求
        try {
            Document doc = Jsoup.connect(url).get(); //返回html数据
           // System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------Get请求 参数处理1----------------------------------------");
        //Get请求 参数处理一,字符串拼接
        String params = "page=2";
        String url_  = url + "?" + params;
        try {
            Document doc = Jsoup.connect(url_).get(); //返回html数据
            //System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------Get请求 参数处理2----------------------------------------");
        //Document对象上添加参数
        try {
            Connection conn = Jsoup.connect(url);
            conn.data("page", "2");
            Document doc = conn.get();
            //System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------Get请求 带请求头信息----------------------------------------");
        //获取请求连接
        Connection conn = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
        conn.header("Accept", "text/html, application/xhtml+xml, */*");
        conn.header("Content-Type", "application/x-www-form-urlencoded");
        conn.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        conn.header("Cookie", "cookie");
        try {
            //解析请求结果
            Document doc = conn.get();
            //获取标题
            //System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------Get请求 获取响应码, 响应信息----------------------------------------");
        try {
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
