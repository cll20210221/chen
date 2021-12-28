package com.wlsj2021.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.modules.conversation.EaseConversationListFragment;

public class UCConversationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucconversation_list);


        EaseConversationListFragment easeChatFragment = new EaseConversationListFragment();
        //传入参数
        //EXTRA_USER_ID
        Bundle args = new Bundle();
//        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_CONVERSATION_ID, getIntent().getStringExtra("user_id"));
        easeChatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.conversation, easeChatFragment).commit();


    }
}