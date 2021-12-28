package com.wlsj2021.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.modules.chat.EaseChatFragment;
import com.hyphenate.easeui.modules.contact.EaseContactListFragment;
import com.hyphenate.easeui.modules.conversation.EaseConversationListFragment;
import com.hyphenate.exceptions.HyphenateException;

public class MainActivity extends AppCompatActivity {

    public static final int SINGLE = 1;

    public static final int GROUP = 2;

    public static final int CHATROOM = 3;

    public static final String CHAT_TYPE = "chatType";
    public static final String USE_ID = "useId";
    private String mUseName;
    //聊天界面
    private EaseChatFragment easeChatFragment;
    //会话
    private EaseConversationListFragment easeConversationListFragment;
    //联系人
    private EaseContactListFragment easeContactListFragment;
    private TextView tvMyChatID;
    private EditText etToChatID;
    private Button btnStartChat;
    private Button btnChatList;
    private Button btnFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMyChatID = findViewById(R.id.tv_my_user_id);
        etToChatID = findViewById(R.id.et_to_chat_id);
        btnStartChat = findViewById(R.id.btn_start_chat);
        btnChatList = findViewById(R.id.btn_chat_list);
        btnFriend = findViewById(R.id.btn_friend);

        String user_id = getIntent().getStringExtra("user_id").toString();
        tvMyChatID.setText(user_id);


        btnStartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to_chat_id = etToChatID.getText().toString().trim();
                if (!TextUtils.isEmpty(to_chat_id)) {
                    startActivity(new Intent(MainActivity.this,UCChartActivity.class)
                            .putExtra("user_id",to_chat_id));
                }else{
                    Toast.makeText(MainActivity.this,"其输入正确的ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to_chat_id = etToChatID.getText().toString().trim();
                if (!TextUtils.isEmpty(to_chat_id)) {
                    startActivity(new Intent(MainActivity.this, UCConversationListActivity.class)
                            .putExtra("user_id",to_chat_id));
                }else{
                    Toast.makeText(MainActivity.this,"其输入正确的ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to_chat_id = etToChatID.getText().toString().trim();
                if (!TextUtils.isEmpty(to_chat_id)) {
                    startActivity(new Intent(MainActivity.this,UCContactListActivity.class)
                            .putExtra("user_id",to_chat_id));
                }else{
                    Toast.makeText(MainActivity.this,"其输入正确的ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void fab_click(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(UCLoginActivity.this
//                        , MainActivity.class).putExtra("user_id",ucEtUsername.getText().toString().trim()));
//                finish();
                try {
                    EMClient.getInstance().contactManager().addContact(etToChatID.getText().toString(), "请求你添加我");
                    Toast.makeText(MainActivity.this, "已经向好友发起请求"+etToChatID.getText().toString()+"已同意", Toast.LENGTH_SHORT).show();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }

            }
        });

    }

//           //use EaseChatFratFragment
//        mUseName =getIntent().getExtras().getString("zhangsan");
//        easeContactListFragment = new EaseContactListFragment();
//
//           //pass parameters to chat fragment
//        easeContactListFragment.setArguments(getIntent().getExtras());
//        getSupportFragmentManager().beginTransaction().add(R.id.frame, easeContactListFragment).commit();
    }

