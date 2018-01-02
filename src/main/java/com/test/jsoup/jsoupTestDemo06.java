package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvjing02 on 12/28/2017.
 * 使用选择器语法来查找元素
 */
public class jsoupTestDemo06 {
    public static void main(String args[]){
        Document doc = null;
        try {
            String path = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
            File file = new File(path + "1.html");
            doc = Jsoup.parse(file, "utf-8");
            Element content =doc.getElementById("content");
            System.out.println(content.text()); //运行结果：Hello World!Wa
            Elements links = doc.getElementsByTag("a");
            for (Element link:links) {
                System.out.println(link.attr("href"));
            }
            /*
            运行结果：
            one.html
            two.html
            three.html
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
