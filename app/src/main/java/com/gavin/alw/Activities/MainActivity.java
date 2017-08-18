package com.gavin.alw.Activities;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.gavin.alw.R;
import com.gavin.alw.utils.*;

/**
 * Create by Gavin_Y on 2017/8/16
 */
public class MainActivity extends AppCompatActivity {
    private Button hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = (Button)findViewById(R.id.hello);
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message msg = new Message();
                msg.what = 2;
                msg.arg1 = 1;
                msg.arg2 = 1;
                mHandler.setContext(MainActivity.this).sendMessage(msg);
            }
        });
    }

    @Override
    protected void onStart() {
        mHandler.setContext(this);
        super.onStart();
    }
}
