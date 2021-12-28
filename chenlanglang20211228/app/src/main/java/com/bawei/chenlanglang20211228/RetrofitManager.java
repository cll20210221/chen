package com.bawei.chenlanglang20211228;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Date:2021/12/28
 * Time:8:17
 * author:chenlanglang
 * Describe:
 * <p>
 * .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------. .----------------.
 * | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
 * | |     ______   | || |  ____  ____  | || |  _________   | || | ____  _____  | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | |
 * | |   .' ___  |  | || | |_   ||   _| | || | |_   ___  |  | || ||_   \|_   _| | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | |
 * | |  / .'   \_|  | || |   | |__| |   | || |   | |_  \_|  | || |  |   \ | |   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | |
 * | |  | |         | || |   |  __  |   | || |   |  _|  _   | || |  | |\ \| |   | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | |
 * | |  \ `.___.'\  | || |  _| |  | |_  | || |  _| |___/ |  | || | _| |_\   |_  | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | |
 * | |   `._____.'  | || | |____||____| | || | |_________|  | || ||_____|\____| | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | |
 * | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
 * | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
 * '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
 */
public class RetrofitManager {

    private volatile static RetrofitManager manager;

    public static RetrofitManager getManager() {
        if (manager == null){
            synchronized (RetrofitManager.class){
                if (manager == null){
                    manager = new RetrofitManager();
                }
            }
        }
        return manager;
    }

    public Retrofit getRetrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient.Builder()
                        .connectTimeout(2, TimeUnit.SECONDS)
                        .writeTimeout(2,TimeUnit.SECONDS)
                        .readTimeout(2,TimeUnit.SECONDS)
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
