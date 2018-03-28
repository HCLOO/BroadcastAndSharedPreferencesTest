package com.example.think.broatcastandsharedtest;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("已被强制退线，请重新登录！");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.removeAll();
                Intent intent1=new Intent(context,LoginMainActivity.class);
                context.startActivity(intent1);
            }
        });
        builder.show();
    }
}
