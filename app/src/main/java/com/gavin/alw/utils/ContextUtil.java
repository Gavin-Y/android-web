package com.gavin.alw.utils;

import android.app.Application;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class ContextUtil extends Application{
    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("start");
        instance = this;
    }
}
