package com.bawei.huanxin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPass;
    private Button reg;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        userPass = (EditText) findViewById(R.id.userPass);
        reg = (Button) findViewById(R.id.reg);
        login = (Button) findViewById(R.id.login);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String trim = userName.getText().toString().trim();
                        String trim1 = userPass.getText().toString().trim();
                        try {
                            EMClient.getInstance().createAccount(trim,trim1);
                            Toast.makeText(MainActivity.this, "注册成功!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }
}