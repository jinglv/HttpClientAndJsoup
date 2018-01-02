package com.test.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by lvjing02 on 12/28/2017.
 * 解析一个HTML字符串
 */
public class jsoupTestDemo01 {
    public static void main(String args[]) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html); //解析HTML
        System.out.println(doc);
       /*
       运行结果：
       <html>
         <head>
          <title>First parse</title>
         </head>
         <body>
          <p>Parsed HTML into a doc.</p>
         </body>
        </html>
        */
    }
}
