package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvjing02 on 1/2/2018.
 * 设置元素的html内容
 */
public class jsoupTestDemo09 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
        File file = new File(path + "1.html");
        Document doc = Jsoup.parse(file, "utf-8");
        System.out.println("-------------------------Before-----------------------------------------");
        System.out.println(doc);
        Element div = doc.select("div").first(); // <div></div>
        div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
        div.prepend("<p>First</p>");//在div前添加html内容
        div.append("<p>Last</p>");//在div之后添加html内容
        // 添完后的结果: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>

        Element span = doc.select("a").first(); // <span>One</span>
        span.wrap("<li><a href='http://example.com/'></a></li>");
        // 添完后的结果: <li><a href="http://example.com"><span>One</span></a></li>
        System.out.println("-------------------------After-----------------------------------------");
        System.out.println(doc);
    }
}
