package com.example.loginwithgoogle.NetworkPublic;

import com.example.loginwithgoogle.Network.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServicePublic {
    public static Retrofit getRetrofitServices(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = (new OkHttpClient.Builder()).connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(ApiPublic.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRetrofitServicesCorona(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = (new OkHttpClient.Builder()).connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(ApiPublic.BASE_URL2)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRetrofitServicesAll(String BaseURL){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = (new OkHttpClient.Builder()).connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
