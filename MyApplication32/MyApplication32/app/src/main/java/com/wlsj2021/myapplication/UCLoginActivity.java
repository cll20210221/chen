package com.wlsj2021.myapplication;

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


public class UCLoginActivity extends AppCompatActivity {
    EditText ucEtUsername;
    EditText ucEtPassword;
    Button ucBtnLoginUp;
    Button ucBtnLoginIn;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc_activity_login);

        EMClient.getInstance().logout(true);

        ucEtUsername = findViewById(R.id.uc_et_username);
        ucEtPassword = findViewById(R.id.uc_et_password);
        ucBtnLoginUp = findViewById(R.id.uc_btn_login_up);
        ucBtnLoginIn = findViewById(R.id.uc_btn_login_in);

        ucBtnLoginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUp();
            }
        });
        ucBtnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginIn();
            }
        });
    }

    /**
     * 注册
     */
    private void loginUp() {

        final String userName = ucEtUsername.getText().toString().trim();
        final String passWord = ucEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(UCLoginActivity.this,"用户名错误",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            Toast.makeText(UCLoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //注册新用户
                    EMClient.getInstance().createAccount(userName, passWord);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(UCLoginActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.e("wjp", "注册失败：" + e.getErrorCode() + ", " + e.getMessage());
                }
            }
        }).start();

    }

    /**
     * 登录
     */
    private void loginIn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //登录
                EMClient.getInstance().login(ucEtUsername.getText().toString().trim()
                        , ucEtPassword.getText().toString().trim(), new EMCallBack() {
                            @Override
                            public void onSuccess() {
                                EMClient.getInstance().groupManager().loadAllGroups();
                                EMClient.getInstance().chatManager().loadAllConversations();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(UCLoginActivity.this, MainActivity.class).putExtra("user_id",ucEtUsername.getText().toString().trim()));
                                        finish();
                                    }
                                });
                            }

                            @Override
                            public void onError(int i, String s) {
                                Log.e("TAG", "onError-----------------------: "+s,null );
//                               EMClient.getInstance().logout(true);

                            }

                            @Override
                            public void onProgress(int i, String s) {

                            }
                        });
            }
        }).start();
    }
}
