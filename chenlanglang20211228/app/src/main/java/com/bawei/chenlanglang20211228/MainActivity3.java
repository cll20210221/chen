package com.bawei.chenlanglang20211228;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bawei.chenlanglang20211228.fragmenr.BlankFragment;
import com.bawei.chenlanglang20211228.fragmenr.BlankFragment2;
import com.bawei.chenlanglang20211228.fragmenr.Fragmentdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());

        ArrayList<String> strings = new ArrayList<>();
        strings.add("中华靓丽");
        strings.add("中华料理");

        Fragmentdapter fragmentdapter = new Fragmentdapter(getSupportFragmentManager(), fragments, strings);
        vp.setAdapter(fragmentdapter);
        tab.setupWithViewPager(vp);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View inflate = LayoutInflater.from(MainActivity3.this).inflate(R.layout.three, null);
                TextView viewById = inflate.findViewById(R.id.three_text);
                for (int i = 0; i < strings.size(); i++) {
                    viewById.setText(strings.get(i));
                }
                tab.setCustomView(viewById);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}