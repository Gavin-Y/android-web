package com.gavin.alw.utils;

import android.app.Application;
import com.gavin.alw.config.WebConfig;

import static com.gavin.alw.config.WebConfig.URL_LIST;

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
        WebConfig.push(URL_LIST[0]);
        instance = this;
    }
}
