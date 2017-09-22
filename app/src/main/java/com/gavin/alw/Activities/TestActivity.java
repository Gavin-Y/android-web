package com.gavin.alw.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.gavin.alw.R;

public class TestActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = (TextView) findViewById(R.id.views);
    }
}
