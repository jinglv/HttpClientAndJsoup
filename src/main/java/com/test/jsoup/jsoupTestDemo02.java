package com.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

/**
 * Created by lvjing02 on 12/28/2017.
 * 解析一个body片断
 *
 * Whitelist类定义了一些可以被保留的标签和属性，不属于这个范围的标签和属性的都要被删除。
     默认的配置方法有：
     none() 只保留了文本；
     simpleText() 简单的文本属性b, em, i, strong, u
     basic() a, b, blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q,small,strike, strong, sub, sup, u, ul
     basicWithImages() a, b, blockquote, br, cite, code, dd, dl,dt, em, i, li, ol, p, pre, q, small, strike, strong, sub, sup, u, ul、img、src
     relaxed() a, b, blockquote,br, caption, cite, code, col, colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6,i, img, li, ol, p, pre, q, small, strike, strong, sub, sup, table, tbody, td,tfoot, th, thead, tr, u, ul
     自定义过滤器，如果想扩大筛选范围，可以使用以下方法：
     addTags(java.lang.String...)
     addAttributes(java.lang.String,java.lang.String...)
     addEnforcedAttribute(java.lang.String,java.lang.String, java.lang.String)
     addProtocols(java.lang.String,java.lang.String, java.lang.String...)
 */
public class jsoupTestDemo02 {
    public static void main(String args[]) {
        String html = "<div><p>Lorem ipsum.</p>";
        Element body = parseHtmlFragmentFromStringNotSafe(html);
        System.out.println(body);
        /*
        运行结果
        <body>
         <div>
          <p>Lorem ipsum.</p>
         </div>
        </body>
        */
        Element body2 = parseHtmlFragmentFromStringSafe(html);
        System.out.println(body2);
    }

    /**
     * 将String转换成Html片段,注意防止跨站脚本攻击
     * 这是一个不安全的方法
     *
     * @param html
     * @return
     */
    public static Element parseHtmlFragmentFromStringNotSafe(String html) {
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }

    /**
     * 将String转换成Html片段,注意防止跨站脚本攻击
     * 这是一个安全的方法
     *
     * @param html
     * @return
     */
    public static Element parseHtmlFragmentFromStringSafe(String html) {
        //白名单列表定义了哪些元素和属性可以通过清洁器，其他的元素和属性一律移除
        Whitelist wl = new Whitelist();

        //另外还可以自定义过滤规则,例如
        wl.addTags("a");

        //执行过滤
        Jsoup.clean(html, Whitelist.none());
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }

    public static void JsoupClean(String html){

    }
}
