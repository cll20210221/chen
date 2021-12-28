package com.bawei.buglytest;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Date:2021/12/7
 * Time:8:48
 * author:chenlanglang
 * Describe:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        在测试的时候改成true
//        CrashReport.initCrashReport(getApplicationContext(), "423a52af32", true);
        Bugly.init(getApplicationContext(), "423a52af32", false);
    }
}
