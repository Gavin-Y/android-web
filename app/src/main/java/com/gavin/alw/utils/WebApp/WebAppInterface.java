package com.gavin.alw.utils.WebApp;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;

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

    @JavascriptInterface
    public void showList(){
        System.out.println("1");
        new AlertView("筛选条件", null, "取消", new String[]{"查找关键字"},
                new String[]{"最新评论", "按评分从高到低"},mContext,
                AlertView.Style.ActionSheet, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                switch (position){
                    case 0:
                        showToast("输入关键字");break;
                    case 1:
                        showToast("获取最新评论");break;
                    case 2:
                        showToast("获取评分高低");break;
                }
            }
        }).show();
    }

}
