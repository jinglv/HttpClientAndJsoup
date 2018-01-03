package com.test.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by lvjing02 on 1/2/2018.
 * post请求
 * Jsoup的post请求只支持表单提交
 */
public class jsoupTestPost {
    public static void main(String[] args){
        System.out.println("------------------------------POST请求----------------------------------------");
        try {
            String url = "https://passport.jd.com/new/login.aspx";
            Connection conn = Jsoup.connect(url);
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
            Connection conn = Jsoup.connect(url);
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
    }
}
