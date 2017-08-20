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

    private static Stack<String> urlStack = new Stack<>();

    public static void push(String item){
        urlStack.push(item);
        Log.i("Gavin",getUrl());
    }

    public static void pop(){
        urlStack.pop();
        Log.i("Gavin",getUrl());
    }

    public static String getUrl(){
        return urlStack.peek();
    }
}
