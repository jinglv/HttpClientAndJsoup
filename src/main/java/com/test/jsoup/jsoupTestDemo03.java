package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvjing02 on 12/28/2017.
 * 从一个URL加载一个Document
 */
public class jsoupTestDemo03 {
    public static void main(String args[]){
        Document doc = null;
        try {
           // doc = Jsoup.connect("http://code.vmware.com").get();
            String path = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
            File file = new File(path + "1.html");
            doc = Jsoup.parse(file, "utf-8");
            String title = doc.title();
            System.out.println(title);
            /*
            运行结果：
            First parse
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
