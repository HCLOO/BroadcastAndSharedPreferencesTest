package com.example.think.broatcastandsharedtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send=(Button) findViewById(R.id._send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.think.broatcastandsharedtest.MY_BROASTCAST");
                sendBroadcast(intent);
            }
        });

    }
}
