package com.bawei.huanxin382;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.modules.chat.EaseChatFragment;

/**
 * 聊天
 */
public class UCCChitchatActivity extends AppCompatActivity {

    private FrameLayout chitchatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uccchitchat);

        initView();

        EaseChatFragment easeChatFragment = new EaseChatFragment();
//        输入参数
//        EXTRA_USER_ID
        Bundle bundle = new Bundle();
        bundle.getInt(EaseConstant.EXTRA_CHAT_TYPE,EaseConstant.CHATTYPE_SINGLE);
        bundle.getString(EaseConstant.EXTRA_CONVERSATION_ID,getIntent().getStringExtra("id"));
        easeChatFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.chitchat_fragment,easeChatFragment)
                .commit();
    }

    private void initView() {
        chitchatFragment = (FrameLayout) findViewById(R.id.chitchat_fragment);
    }
}