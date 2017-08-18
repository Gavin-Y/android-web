package com.gavin.alw.utils;

import android.content.Context;
import android.os.Message;
import android.webkit.JavascriptInterface;

import static com.gavin.alw.Activities.NowActivity.mHndle;
import static com.gavin.alw.utils.mHandler.*;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class WebAppInterface {
    private Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }
    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Message msg = new Message();
        msg.arg1 = SHOW_TOAST;
        msg.obj = toast;
        mHndle.sendMessage(msg);
    }

    @JavascriptInterface
    public void showAlert() {
        Message msg = new Message();
        msg.arg1 = SHOW_ALERT;
        mHndle.sendMessage(msg);
    }
}
