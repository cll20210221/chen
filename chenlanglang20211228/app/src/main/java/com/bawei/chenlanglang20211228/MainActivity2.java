package com.bawei.chenlanglang20211228;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {
    private WebView main2Wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        main2Wv = (WebView) findViewById(R.id.main2_wv);

        main2Wv.loadUrl("https://www.baidu.com");

    }
}