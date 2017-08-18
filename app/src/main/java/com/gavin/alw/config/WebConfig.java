package com.gavin.alw.config;


/**
 * Create by Gavin_Y on 2017/8/18
 */
public class WebConfig {

    public static final String[]WEB_LIST = new String[]{
            "file:///android_asset/index.html",
            "file:///android_asset/test.html"
    };

    public static int tag = 0;

    public static String getUrl(){
        return WEB_LIST[tag];
    }

    public static String getUrl(int i){
        return WEB_LIST[i];
    }
}
