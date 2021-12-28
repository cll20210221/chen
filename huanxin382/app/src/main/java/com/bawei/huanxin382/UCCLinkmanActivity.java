package com.bawei.huanxin382;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.modules.chat.EaseChatFragment;

/**
 * 联系人
 */
public class UCCLinkmanActivity extends AppCompatActivity {

    private FrameLayout linkmanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucclinkman);
        initView();

        EaseChatFragment easeChatFragment = new EaseChatFragment();

        Bundle bundle = new Bundle();
        bundle.getInt(EaseConstant.EXTRA_CHAT_TYPE,EaseConstant.CHATTYPE_SINGLE);
        bundle.getString(EaseConstant.EXTRA_CONVERSATION_ID);
        easeChatFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.linkman_fragment,easeChatFragment)
                .commit();


    }

    private void initView() {
        linkmanFragment = (FrameLayout) findViewById(R.id.linkman_fragment);
    }
}