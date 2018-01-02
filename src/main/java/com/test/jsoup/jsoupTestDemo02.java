package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by lvjing02 on 12/28/2017.
 * 解析一个body片断
 */
public class jsoupTestDemo02 {
    public static void main(String args[]){
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
        /*
        运行结果
        <body>
         <div>
          <p>Lorem ipsum.</p>
         </div>
        </body>
        */
    }
}
