package com.gavin.alw.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.gavin.alw.R;
import com.gavin.alw.utils.*;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class NowActivity extends AppCompatActivity {

    private mWebView mWebView;
    private LinearLayout all;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);
        all = (LinearLayout)findViewById(R.id.all);
        mWebView = new mWebView(this);
        mWebView.loadUrl("file:///android_asset/index.html");
        all.addView(mWebView);
    }

    @Override
    protected void onStart() {
        mHandler.setContext(this);
        super.onStart();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
