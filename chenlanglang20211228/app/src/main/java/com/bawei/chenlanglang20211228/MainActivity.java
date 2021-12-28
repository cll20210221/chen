package com.bawei.chenlanglang20211228;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.bawei.chenlanglang20211228.mvp.Food;
import com.bawei.chenlanglang20211228.mvp.FoodCon;
import com.bawei.chenlanglang20211228.mvp.FoodModel;
import com.bawei.chenlanglang20211228.mvp.FoodPresenter;
import com.bawei.library_mvp.view.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<FoodPresenter> implements FoodCon.FoodConView, OnRefreshLoadMoreListener {


    private Banner mainBanner;
    private RecyclerView mainRecyclerview;
    protected FoodPresenter foodPresenter;
    private int page = 1;
    private SmartRefreshLayout mainSmar;
    private    FoodAdapter foodAdapter;
    private boolean isRe = true;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mainBanner = (Banner) findViewById(R.id.main_banner);
        mainRecyclerview = (RecyclerView) findViewById(R.id.main_recyclerview);
        mainRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        foodPresenter = new FoodPresenter(new FoodModel(),this);
        mainSmar = (SmartRefreshLayout) findViewById(R.id.main_smar);
        mainSmar.setOnRefreshLoadMoreListener(this);
    }

    @Override
    public void initData() {
//        轮播图
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.mipmap.yuekao_one);
        integers.add(R.mipmap.yuekao_tow);
        integers.add(R.mipmap.yuekoa_three);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("月考1");
        strings.add("月考2");
        strings.add("月考3");

        mainBanner.setImages(integers);
        mainBanner.setBannerTitles(strings);
        mainBanner.setBannerStyle(BannerConfig.CENTER);
        mainBanner.setIndicatorGravity(Gravity.CENTER);
        mainBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageResource((Integer) path);
            }
        });
        mainBanner.start();


        foodPresenter.getData(page);
    }

    @Override
    public void doFoodConView(List<Food.DataBean> dataBeans) {
        mainSmar.finishLoadMore();
        mainSmar.finishRefresh();
        if (foodAdapter == null){
            foodAdapter = new FoodAdapter(dataBeans);
            mainRecyclerview.setAdapter(foodAdapter);

//           点击商品跳转到详情
            foodAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("foodName",dataBeans.get(position).getTitle());
                    intent.putExtra("foodImg",dataBeans.get(position).getPic());
                    intent.putExtra("foodStr",dataBeans.get(position).getFood_str());
                    startActivity(intent);
                }
            });


        }else {
            if (isRe){
                foodAdapter.getData().clear();
            }
            foodAdapter.getData().addAll(dataBeans);
            foodAdapter.notifyDataSetChanged();
        }

    }
//        上拉刷新下拉加载
    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
        isRe = false;
        page++;
        foodPresenter.getData(page);
    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {
        isRe = true;
        page = 1;
        foodPresenter.getData(page);
    }
    private long l = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis() - l) > 2000){
                ToastUtils.showShort("再点击一次");
                l = System.currentTimeMillis();
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}