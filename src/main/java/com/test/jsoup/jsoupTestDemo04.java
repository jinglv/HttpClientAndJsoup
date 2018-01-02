package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvjing02 on 12/28/2017.
 * 从一个文件加载一个文档
 */
public class jsoupTestDemo04 {
    public static void main(String args[]){
        Document doc = null;
        try {
            // doc = Jsoup.connect("http://code.vmware.com").get();
            String path = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
            File file = new File(path + "1.html");
            doc = Jsoup.parse(file, "utf-8", "https://www.baidu.com");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
