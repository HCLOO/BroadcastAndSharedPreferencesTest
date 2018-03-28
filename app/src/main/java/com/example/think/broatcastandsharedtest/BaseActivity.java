package com.example.think.broatcastandsharedtest;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.think.broatcastandsharedtest.ActivityCollector.activityList;

/**
 * Created by Think on 2018/3/21.
 */

public class BaseActivity extends AppCompatActivity {

    IntentFilter filter;
    MyReceiver receiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        filter=new IntentFilter();
        filter.addAction("com.example.think.broatcastandsharedtest.MY_BROASTCAST");
        receiver=new MyReceiver();
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
