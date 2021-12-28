package com.bawei.buglytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn(View view) {
        int a = 0;
        int b = 10 / a;
//        Toast.makeText(this, "升级版本2.0", Toast.LENGTH_SHORT).show();
    }
}