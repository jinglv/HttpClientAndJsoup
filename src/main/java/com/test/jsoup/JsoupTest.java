package com.test.jsoup;

import java.util.Map;

/**
 * Created by lvjing02 on 1/3/2018.
 * JsoupUtils的测试类
 */
public class JsoupTest {
    public static void main(String[] args){
        String url = "https://www.baidu.com/";
        String doc = JsoupUtils.doGet(url).title();
        System.out.println(doc);

        int statusCode = JsoupUtils.doGetResponse(url).statusCode();
        Map<String, String> cookies = JsoupUtils.doGetResponse(url).cookies();
        System.out.println(statusCode);
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey()+ ":" +entry.getValue());
        }
    }
}
