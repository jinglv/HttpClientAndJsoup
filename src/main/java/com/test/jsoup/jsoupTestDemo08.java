package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by lvjing02 on 1/2/2018.
 * 设置属性的值
 */
public class jsoupTestDemo08 {
    public static void main(String[] args) throws IOException {
        String url = "https://code.vmware.com";
        Document doc = Jsoup.connect(url).get();

        String link = doc.select(".brand.code_logo.internal").attr("abs:href");
        System.out.println("link_before:" + link); // link_before:https://code.vmware.com/

        Element link_after = doc.attr("href","http://www.baidu.com/");
        System.out.println("link_after:" + link_after.attr("href")); //link_after:http://www.baidu.com/

    }
}
