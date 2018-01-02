package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvjing02 on 1/2/2018.
 * 设置元素的文本内容
 */
public class jsoupTestDemo10 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
        File file = new File(path + "1.html");
        Document doc = Jsoup.parse(file, "utf-8");
        System.out.println("-------------------------Before-----------------------------------------");
        System.out.println(doc);

        Element div = doc.select("div").first(); // <div></div>
        div.text("five > four"); // <div>five &gt; four</div>
        div.prepend("First ");
        div.append(" Last"); // now: <div>First five &gt; four Last</div>
        System.out.println("-------------------------After-----------------------------------------");
        System.out.println(doc);
    }
}
