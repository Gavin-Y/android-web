package com.gavin.alw.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.gavin.alw.R;
import com.gavin.alw.config.WebConfig;
import com.gavin.alw.utils.*;
import com.gavin.alw.views.*;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class NowActivity extends AppCompatActivity {

    private com.gavin.alw.views.mWebView mWV;
    private LinearLayout all;
    private mToolBar mTB;
    public static Handler titleHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);
        all = (LinearLayout)findViewById(R.id.all);
        mTB = (mToolBar)findViewById(R.id.toolbar);

        mWV = new mWebView(this);
        mWV.loadUrl(WebConfig.getUrl());
        all.addView(mWV);

        titleHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mTB.setTitle(mWV.getTitle());
            }
        };

        mTB.setTitle("");
        mTB.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mTB);
    }

    @Override
    protected void onStart() {
        mHandler.setContext(this);
        super.onStart();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWV.canGoBack()) {
            mWV.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
