package com.bawei.huanxin382;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class UCCLoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button reg;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucclogin);
        initView();

//        注册
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regReg();
            }
        });
//        登陆
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regLogin();
            }
        });

    }

    private void regLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EMClient.getInstance().login(user.getText().toString().trim(), pass.getText().toString().trim(), new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        EMClient.getInstance().groupManager().loadAllGroups();
                        EMClient.getInstance().chatManager().loadAllConversations();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(UCCLoginActivity.this,MainActivity.class)
                                .putExtra("id",user.getText().toString().trim()));
                                Toast.makeText(UCCLoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String error) {

                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        Toast.makeText(UCCLoginActivity.this, "登陆失败！！！", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    private void regReg() {
        String user_name = user.getText().toString().trim();
        String user_pass = pass.getText().toString().trim();

        if (TextUtils.isEmpty(user_name)){
            Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(user_pass)){
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(user_name,user_pass);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(UCCLoginActivity.this, "注册成功！！！！！", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (HyphenateException e) {
                    e.printStackTrace();

                }
            }
        }).start();
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        reg = (Button) findViewById(R.id.reg);
        login = (Button) findViewById(R.id.login);
    }
}