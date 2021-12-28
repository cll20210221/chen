package com.bawei.huanxin382;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button startChat;  //开始聊天
    private Button dialogueList;  //会话列表
    private Button linkmanList;  //联系人列表
    private TextView id;
    private EditText idEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startChat = (Button) findViewById(R.id.startChat);
        dialogueList = (Button) findViewById(R.id.dialogueList);
        linkmanList = (Button) findViewById(R.id.linkmanList);
        id = (TextView) findViewById(R.id.id);
        idEt = (EditText) findViewById(R.id.id_Et);


        String User_Id = getIntent().getStringExtra("id");
//        聊天
        startChatList();
//        会话列表
        dialogueListList();
//        联系人列表
        linkmanListList();



    }

    private void linkmanListList() {
        String trim = idEt.getText().toString().trim();
        if (TextUtils.isEmpty(trim)){
            startActivity(new Intent(MainActivity.this,
                    UCCLinkmanActivity.class).putExtra("id",trim));

        }else {
            Toast.makeText(this, "请输入正确的ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void dialogueListList() {
        String trim = idEt.getText().toString().trim();
        if (TextUtils.isEmpty(trim)){
            startActivity(new Intent(MainActivity.this,UCCDialogueActivity.class).putExtra("id",trim));

        }else {
            Toast.makeText(this, "请输入正确的ID", Toast.LENGTH_SHORT).show();
        }
    }

    //        开始聊天
    private void startChatList() {
        String trim = idEt.getText().toString().trim();
        if (TextUtils.isEmpty(trim)){
                startActivity(new Intent(MainActivity.this,UCCChitchatActivity.class).putExtra("id",trim));
        }else {
            Toast.makeText(this, "请输入正确的ID", Toast.LENGTH_SHORT).show();
        }
    }

}