package com.example.loginwithgoogle.Menu.news.coronainfo;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaViewModel extends ViewModel {
    private Context context;
    private MutableLiveData<ResponseIndo> mutableLiveData=new MutableLiveData<>();
    public void setDataIndo(){
        Retrofit retrofit= ApiServicePublic.getRetrofitServicesCorona();
        EndPointPublic endPointPublic=retrofit.create(EndPointPublic.class);
        Call<ResponseIndo> call=endPointPublic.getIndoneisaStats();
        call.enqueue(new Callback<ResponseIndo>() {
            @Override
            public void onResponse(Call<ResponseIndo> call, Response<ResponseIndo> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseIndo> call, Throwable t) {
            }
        });
    }

    public MutableLiveData<ResponseIndo> getMutableLiveData() {
        return mutableLiveData;
    }

}
