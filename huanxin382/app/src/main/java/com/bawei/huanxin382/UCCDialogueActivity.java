package com.bawei.huanxin382;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.modules.chat.EaseChatFragment;

/**
 * 会话
 */
public class UCCDialogueActivity extends AppCompatActivity {

    private FrameLayout dialogueFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uccdialogue);

        dialogueFragment = (FrameLayout) findViewById(R.id.dialogue_fragment);

        EaseChatFragment easeChatFragment = new EaseChatFragment();
        Bundle bundle = new Bundle();
        bundle.getInt(EaseConstant.EXTRA_CHAT_TYPE,EaseConstant.CHATTYPE_SINGLE);
        bundle.getString(EaseConstant.EXTRA_CONVERSATION_ID,getIntent().getStringExtra("id"));
        easeChatFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.dialogue_fragment,easeChatFragment)
                .commit();

    }
}