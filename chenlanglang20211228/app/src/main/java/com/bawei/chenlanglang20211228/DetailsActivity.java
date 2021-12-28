package com.bawei.chenlanglang20211228;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.library_mvp.view.BaseActivity;
import com.bumptech.glide.Glide;

public class DetailsActivity extends BaseActivity {


    private ImageView detaImg;
    private TextView detaName;
    private TextView detaFood;
    private Button wv;


    @Override
    public int bindLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void initView() {

        wv = (Button) findViewById(R.id.wv);

        detaImg = (ImageView) findViewById(R.id.deta_Img);
        detaName = (TextView) findViewById(R.id.deta_name);
        detaFood = (TextView) findViewById(R.id.deta_food);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String foodName = intent.getStringExtra("foodName");
        String foodStr = intent.getStringExtra("foodStr");
        String foodImg = intent.getStringExtra("foodImg");
        Glide.with(this).load(foodImg).into(detaImg);


        detaName.setText(foodName);
        detaFood.setText(foodStr);

        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        加载https://www.baidu.com
                Intent intent1 = new Intent(DetailsActivity.this, MainActivity2.class);
                startActivity(intent1);
            }
        });




    }
}