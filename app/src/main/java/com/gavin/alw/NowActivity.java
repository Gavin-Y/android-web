package com.gavin.alw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.view.KeyEvent.KEYCODE_BACK;

public class NowActivity extends Activity{

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        webView = (WebView) findViewById(R.id.web);

        webView.loadUrl("http://115.28.216.244/html/Hacker.html");

        //设置不用系统浏览器打开,直接显示在当前Webview
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                //去除流量状态下运营商图标
                view.loadUrl("javascript:document.getElementById('statusholder').remove();");
                view.loadUrl("javascript:document.getElementById('progresstextholder').remove();");
                view.loadUrl("javascript:document.getElementById('ftsiappholder').remove();");
                view.loadUrl("javascript:document.getElementById('tlbstoolbar').remove();");

                super.onPageFinished(view, url);
            }
        });

        webView.canGoBack();
        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false);//垂直不显示

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

//        离线模式
//        if (NetStatusUtil.isConnected(getApplicationContext())) {
//            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
//        } else {
//            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
//        }
//
//        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
//        webSettings.setDatabaseEnabled(true);   //开启 database storage API 功能
//        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
//
//        String cacheDirPath = getFilesDir().getAbsolutePath() + "ALW";
//        webSettings.setAppCachePath(cacheDirPath); //设置  Application Caches 缓存目录

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
