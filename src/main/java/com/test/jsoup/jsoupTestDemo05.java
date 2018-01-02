package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by lvjing02 on 12/28/2017.
 * 使用DOM方法来遍历一个文档
 */
public class jsoupTestDemo05 {
    public static void main(String args[]){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://code.vmware.com").get();
            Elements links = doc.select("a[href]"); //带有href属性的a元素
            for(Element link : links){
                System.out.println(link.attr("abs:href"));
            }
            Elements pngs = doc.select("img[src$=.png]"); ////扩展名为.png的图片
            for(Element png : pngs){
                System.out.println(png);
            }
            Element masthead = doc.select("div.masthead").first(); //class等于masthead的div标签

            Elements resultLinks = doc.select("h3.r > a"); //在h3元素之后的a元素
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
