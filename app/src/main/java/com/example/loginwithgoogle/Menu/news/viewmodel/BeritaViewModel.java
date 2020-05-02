package com.example.loginwithgoogle.Menu.news.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.Network.ApiEndPoint;
import com.example.loginwithgoogle.Network.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BeritaViewModel extends ViewModel {
    private MutableLiveData<List<BeritaItem>> mutableLiveData=new MutableLiveData<>();
    public void setDataBerita(){
        Retrofit retrofit= ApiService.getRetrofitServices();
        ApiEndPoint apiEndPoint=retrofit.create(ApiEndPoint.class);
        Call<BeritaItem> call=apiEndPoint.getBerita();
        call.enqueue(new Callback<BeritaItem>() {
            @Override
            public void onResponse(Call<BeritaItem> call, Response<BeritaItem> response) {
                mutableLiveData.setValue((List<BeritaItem>)response.body());
            }
            @Override
            public void onFailure(Call<BeritaItem> call, Throwable t) {
            }
        });
    }

    public MutableLiveData<List<BeritaItem>> getBerita() {
        return mutableLiveData;
    }
}
