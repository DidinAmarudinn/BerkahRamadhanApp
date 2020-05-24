package com.example.loginwithgoogle.Menu.news.coronainfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WorldViewModel extends ViewModel {
    MutableLiveData<ResponeWorld> mutableLiveData=new MutableLiveData<>();
    public void setMutableLiveData(){
        Retrofit retrofit= ApiServicePublic.getRetrofitServicesCorona();
        EndPointPublic endPointPublic=retrofit.create(EndPointPublic.class);
        Call<ResponeWorld> call=endPointPublic.getSummaryWorld();
        call.enqueue(new Callback<ResponeWorld>() {
            @Override
            public void onResponse(Call<ResponeWorld> call, Response<ResponeWorld> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponeWorld> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<ResponeWorld> getMutableLiveData() {
        return mutableLiveData;
    }
}
