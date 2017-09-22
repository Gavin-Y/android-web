package com.gavin.alw.utils;

import android.content.Context;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.gavin.alw.Activities.MainActivity;
import com.gavin.alw.Activities.NowActivity;
import com.gavin.alw.config.ActConfig;
import com.gavin.alw.config.WebConfig;

import static com.gavin.alw.utils.mHandler.*;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class WebAppInterface {
    private Context mContext;
    /** 实例化接口并设置上下文 */
    public WebAppInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Message msg = new Message();
        msg.what = SHOW_TOAST;
        msg.obj = toast;
        mHandler.getInstance(mContext).sendMessage(msg);
    }

    @JavascriptInterface
    public void showAlert() {
        Message msg = new Message();
        msg.what = SHOW_ALERT;
        mHandler.getInstance(mContext).sendMessage(msg);
    }

    @JavascriptInterface
    public void jump(int url,int act){
        Message msg = new Message();
        msg.what = JUMP;
        msg.arg1 = url;
        msg.arg2 = act;

        mHandler.getInstance(mContext).sendMessage(msg);
    }
}
