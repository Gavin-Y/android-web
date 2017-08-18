package com.gavin.alw.config;


import android.util.Log;

import java.util.Stack;

/**
 * Create by Gavin_Y on 2017/8/18
 */
public class WebConfig {

    public static final String[]URL_LIST = new String[]{
            "file:///android_asset/index.html",
            "file:///android_asset/test.html"
    };

    public static Stack<String> urlStack = new Stack<>();

    public static String url = URL_LIST[0];

    public static void setUrl(String url) {
        WebConfig.url = url;
    }

    public static void push(String item){
        urlStack.push(item);
    }

    public static void pop(){
        urlStack.peek();
        url = urlStack.pop();
    }

    public static String getUrl(int i){
        return URL_LIST[i];
    }
}
