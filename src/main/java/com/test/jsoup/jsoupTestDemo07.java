package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by lvjing02 on 1/2/2018.
 * 处理URLs
 */
public class jsoupTestDemo07 {
    public static  void main(String args[]){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.open-open.com").get();
            Element link = doc.select("a").first();
            String relHref = link.attr("href"); // == "/"
            String absHref = link.attr("abs:href"); // "http://www.open-open.com/"
            System.out.println("relHref:" + relHref);
            System.out.println("adsHref:" + absHref);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
