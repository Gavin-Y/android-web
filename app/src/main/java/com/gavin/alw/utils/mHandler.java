package com.gavin.alw.utils;


import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.gavin.alw.config.ActConfig;
import com.gavin.alw.config.WebConfig;
import com.gavin.alw.views.mWebView;

/**
 * Create by Gavin_Y on 2017/8/17
 */
public class mHandler extends android.os.Handler{
    static final int SHOW_TOAST = 0;
    static final int SHOW_ALERT = 1;
    static final int JUMP = 2;


    private static mHandler mHandle;
    private Context mContext;

    public static mHandler getInstance(Context context){
        if (mHandle == null)
            mHandle = new mHandler(context);
        return mHandle;
    }

    public static mHandler setContext(Context context){
        getInstance(context);
        if (mHandle.mContext != context)
            mHandle = new mHandler(context);
        return mHandle;
    }

    private mHandler(Context context){
        this.mContext = context;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case SHOW_TOAST:showToast(msg.obj.toString());break;
            case SHOW_ALERT:showAlert();break;
            case JUMP:jump(msg.arg1,msg.arg2);break;
        }
    }

    private void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    private void showAlert(){
        new AlertView("筛选条件", null, "取消", new String[]{"查找关键字"},
                new String[]{"最新评论", "按评分从高到低"}, mContext,
                AlertView.Style.ActionSheet, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                String url;
                switch (position){
                    case 0:
                        url = "javascript:alt('查找关键字')";
                        mWebView.getInstance(mContext).loadUrl(url);
                        break;
                    case 1:
                        url = "javascript:alt('最新评论')";
                        mWebView.getInstance(mContext).loadUrl(url);
                        break;
                    case 2:
                        url = "javascript:alt('按评分从高到低')";
                        mWebView.getInstance(mContext).loadUrl(url);
                        break;
                    case -1:
                        url = "javascript:alt('取消')";
                        mWebView.getInstance(mContext).loadUrl(url);
                        break;
                }
            }
        }).show();
    }

    private void jump(int url,int clas){
        if (url!=-1) {
            WebConfig.push(WebConfig.URL_LIST[url]);
        }
        Intent intent = new Intent();
        intent.setClass(mContext, ActConfig.CLASS_LIST[clas]);
        mContext.startActivity(intent);
    }
}
