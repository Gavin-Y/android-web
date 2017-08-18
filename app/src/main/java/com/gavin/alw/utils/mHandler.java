package com.gavin.alw.utils;


import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.widget.Toast;
import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.gavin.alw.config.WebConfig;

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
        switch (msg.arg1){
            case SHOW_TOAST:showToast(msg.obj.toString());break;
            case SHOW_ALERT:showAlert();break;
            case JUMP:jump(msg.arg2,msg.obj);break;
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
                switch (position){
                    case 0:
                }
            }
        }).show();
    }

    private void jump(int url,Object clas){
        WebConfig.tag = url;
        Intent intent = new Intent();
        intent.setClass(mContext,(Class) clas);
        mContext.startActivity(intent);
    }
}
