package com.example.think.broatcastandsharedtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMainActivity extends BaseActivity {
    EditText editText;
    EditText editText1;
    Button login;
    CheckBox check;
    SharedPreferences pre;
    SharedPreferences.Editor editor;
    boolean isRemenber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        editText=(EditText)findViewById(R.id.edit);
        editText1=(EditText)findViewById(R.id.edit1);
        login=(Button)findViewById(R.id.button);
        check=(CheckBox)findViewById(R.id.checkbox);
        pre= PreferenceManager.getDefaultSharedPreferences(this);
        isRemenber=pre.getBoolean("remenber_password",false);
        if (isRemenber) {
            check.setChecked(true);
            editText.setText(pre.getString("username",null));
            editText1.setText(pre.getString("password",null));
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().equals("admin")&& editText1.getText().toString().equals("123456")) {
                    editor=pre.edit();
                    if(check.isChecked()) {
                        editor.putBoolean("remenber_password",true);
                        editor.putString("username",editText.getText().toString());
                        editor.putString("password",editText1.getText().toString());
                    }
                    else
                        editor.clear();
                    editor.apply();
                    Intent intent=new Intent(LoginMainActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    editText.setText("");
                    editText1.setText("");
                    Toast.makeText(LoginMainActivity.this,"账号或密码输入错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
