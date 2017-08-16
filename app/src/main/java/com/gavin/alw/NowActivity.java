package com.gavin.alw;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.gavin.alw.utils.WebApp.mWebView;

import static android.view.KeyEvent.KEYCODE_BACK;

public class NowActivity extends Activity{

    private mWebView mWebView;
    private LinearLayout all;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);
        System.out.println("1");
        all = (LinearLayout)findViewById(R.id.all);
        mWebView = new mWebView(this);
        mWebView.loadUrl("file:///android_asset/index.html");
        all.addView(mWebView);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
