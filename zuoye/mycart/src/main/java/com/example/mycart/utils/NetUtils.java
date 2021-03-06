package com.example.mycart.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:08
 *@Description:
 * */


import com.example.mycart.api.ApiServier;
import com.example.mycart.url.MyUrl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {

    private final ApiServier apiServier;

    public NetUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.BEANURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServier = retrofit.create(ApiServier.class);
    }
    private static class net{
        private static NetUtils netUtils=new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public ApiServier getApiServier() {
        return apiServier;
    }
}
