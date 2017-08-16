package com.gavin.alw.utils.WebApp;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class WebAppInterface {
    Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }
    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void addView(){

    }

}
