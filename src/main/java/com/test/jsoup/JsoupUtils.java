package com.test.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lvjing02 on 1/3/2018.
 * jsoup工具类
 */
public class JsoupUtils {

    private final static int timeout = 45000;

    /**
     * Jsoup发送get请求，可进行对文本解析
     * @param url
     * @param params
     * @param headers
     * @return 返回Document String
     */
    public static Document doGet(String url, Map<String, Object> params, Map<String, String> headers){
        //获取请求连接
        Connection connection = Jsoup.connect(url);
        //请求参数
        if(params != null){
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                connection.data(entry.getKey(), entry.getValue().toString());
            }
        }

        //设置请求头
        if(headers != null){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.header(entry.getKey(), entry.getValue());
            }
        }

        //解析请求结果
        Document document = null;
        try {
            document = connection.timeout(timeout).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 重载doGet方法，没有请求参数
     * @param url
     * @param headers
     * @return
     */
    public static Document doGet(String url, Map<String, String> headers){
        return doGet(url, null, headers);
    }

    /**
     *  重载doGet方法，没有请求参数和请求头
     * @param url
     * @return
     */
    public static Document doGet(String url){
        return doGet(url, null);
    }

    /**
     * Jsoup发送Post请求，可进行对文本解析
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Document doPost(String url, Map<String, Object> params, Map<String, String> headers){
        Connection connection = Jsoup.connect(url);
        if(params != null){
            for(Map.Entry<String, Object> param: params.entrySet()){
                connection.data(param.getKey(), param.getValue().toString());
            }
        }

        if(headers != null){
            for (Map.Entry<String, String> header: headers.entrySet()){
                connection.header(header.getKey(), header.getValue());
            }
        }

        Document document = null;
        try {
            document = connection.post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * Jsoup发送Post请求, 可获取statusCode，头信息等
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Connection.Response doPostResponse(String url, Map<String, Object> params, Map<String, String> headers){
        Connection connection = Jsoup.connect(url);
        if(params != null){
            for(Map.Entry<String, Object> param: params.entrySet()){
                connection.data(param.getKey(), param.getValue().toString());
            }
        }

        if(headers != null){
            for (Map.Entry<String, String> header: headers.entrySet()){
                connection.header(header.getKey(), header.getValue());
            }
        }
        Connection.Response resp = null;
        //发送请求
        try {
            resp=connection.timeout(timeout).method(Connection.Method.POST).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * Jsoup发送get请求, 可获取statusCode，头信息等
     * @param url
     * @param params
     * @param headers
     * @return response
     */
    public static Connection.Response doGetResponse(String url, Map<String, Object> params, Map<String, String> headers){
        //获取请求连接
        Connection connection = Jsoup.connect(url);
        //请求参数
        if(params != null){
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                connection.data(entry.getKey(), entry.getValue().toString());
            }
        }

        //设置请求头
        if(headers != null){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.header(entry.getKey(), entry.getValue());
            }
        }

        Connection.Response resp = null;
        //发送请求
        try {
            resp=connection.timeout(timeout).method(Connection.Method.GET).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     *  Jsoup发送get请求, 没有请求参数
     * @param url
     * @param headers
     * @return
     */
    public static Connection.Response doGetResponse(String url, Map<String, String> headers){
        return doGetResponse(url, null, headers);
    }

    /**
     *  Jsoup发送get请求, 没有请求参数和请求头
     * @param url
     * @return
     */
    public static Connection.Response doGetResponse(String url){
        return doGetResponse(url, null);
    }

    /**
     * html解析
     * @param html
     * @return
     */
    public static Document htmlParser(String html){
        Document doc = Jsoup.parse(html);
        return doc;
    }
}
