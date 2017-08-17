package com.gavin.alw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bigkoo.alertview.AlertView;
import com.gavin.alw.utils.mWebView;
import com.gavin.alw.utils.*;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class NowActivity extends Activity{

    private mWebView mWebView;
    private LinearLayout all;
    public static mHandler mHndle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);
        System.out.println("1");
        all = (LinearLayout)findViewById(R.id.all);
        mWebView = new mWebView(this);
        mWebView.loadUrl("file:///android_asset/index.html");
        all.addView(mWebView);
        setHandler();
    }
    
    private void setHandler(){
        mHndle = new mHandler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.arg1){
                    case SHOW_TOAST:showToast(msg.obj.toString());break;
                    case SHOW_ALERT:showAlert();break;
                }
            }
        };
    }

    private void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    private void showAlert(){
        new AlertView("筛选条件", null, "取消", new String[]{"查找关键字"},
                new String[]{"最新评论", "按评分从高到低"},this,
                AlertView.Style.ActionSheet,null).show();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
