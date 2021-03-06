package com.gavin.alw.views;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import com.gavin.alw.config.WebConfig;
import com.gavin.alw.utils.ContextUtil;
import com.gavin.alw.utils.NetworkUtils;
import com.gavin.alw.utils.WebAppInterface;


import static com.gavin.alw.Activities.NowActivity.titleHandler;
import static com.gavin.alw.utils.ContextUtil.getInstance;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class mWebView extends WebView{

    private WebSettings webSettings;
    private static mWebView mWV;
    private Context mContext;

    public static mWebView getInstance(Context context){
        if (mWV == null)
            mWV = new mWebView(context);
        return mWV;
    }

    public static mWebView setContext(Context context){
        getInstance(context);
        if (mWV.mContext != context)
            mWV = new mWebView(context);
        return mWV;
    }

    private mWebView(Context context) {
        super(context);
        this.mContext = context;
        setView();
    }

    @Override
    public void goBack() {
        WebConfig.pop();
        super.goBack();
    }

    private void setView(){
        webSettings = this.getSettings();

        this.setHorizontalScrollBarEnabled(false);//水平不显示
        this.setVerticalScrollBarEnabled(false);//垂直不显示
        this.setJS(mContext);
        webSettings.setAllowFileAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        //设置不用系统浏览器打开,直接显示在当前WebView
        this.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
//                //去除流量状态下运营商图标
//                view.loadUrl("javascript:document.getElementById('statusholder').remove();");
//                view.loadUrl("javascript:document.getElementById('progresstextholder').remove();");
//                view.loadUrl("javascript:document.getElementById('ftsiappholder').remove();");
//                view.loadUrl("javascript:document.getElementById('tlbstoolbar').remove();");
                super.onPageFinished(view, url);
                Message msg = new Message();
                msg.obj = view.getTitle();
                titleHandler.sendMessage(msg);
            }
        });

        this.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //去除流量状态下运营商图标
                view.loadUrl("javascript:document.getElementById('statusholder').remove();");
                view.loadUrl("javascript:document.getElementById('progresstextholder').remove();");
                view.loadUrl("javascript:document.getElementById('ftsiappholder').remove();");
                view.loadUrl("javascript:document.getElementById('tlbstoolbar').remove();");
                super.onProgressChanged(view, newProgress);
            }
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                Message msg = new Message();
//                msg.obj = title;
//                titleHandler.sendMessage(msg);
//            }
        });


//        离线模式
        if (NetworkUtils.isConnected(mContext)) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }

        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);   //开启 database storage API 功能
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能

        String cacheDirPath = mContext.getFilesDir().getAbsolutePath() + "ALW";
        webSettings.setAppCachePath(cacheDirPath); //设置  Application Caches 缓存目录

    }

    private void setJS(Context context){
        webSettings.setJavaScriptEnabled(true);
        this.addJavascriptInterface(new WebAppInterface(context),"BHouse");
    }
}
