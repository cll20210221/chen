package com.wlsj2021.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.modules.chat.EaseChatFragment;


public class UCChartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc_activity_chart);


        EaseChatFragment chatFragment = new EaseChatFragment();
        //传入参数
        //EXTRA_USER_ID
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_CONVERSATION_ID, getIntent().getStringExtra("user_id"));
        chatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.uc_frame_layout, chatFragment).commit();


    }
}

