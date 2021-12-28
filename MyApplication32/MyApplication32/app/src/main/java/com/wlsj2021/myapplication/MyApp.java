package com.wlsj2021.myapplication;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseIM;

public class MyApp extends Application {

    EMOptions emOptions;

    @Override
    public void onCreate() {
        super.onCreate();

        EMOptions options = new EMOptions();
        //emOptions.getAppKey();
        //EaseIM初始化
        options.setAcceptInvitationAlways(true);
        options.setAutoAcceptGroupInvitation(true);
        options.setAutoTransferMessageAttachments(true);
        options.setAutoDownloadThumbnail(true);

        if (EaseIM.getInstance().init(getApplicationContext(), options)) {
            //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
            EMClient.getInstance().setDebugMode(true);
            //EaseIM初始化成功之后再去调用注册消息监听的代码 ...
        }
    }
}