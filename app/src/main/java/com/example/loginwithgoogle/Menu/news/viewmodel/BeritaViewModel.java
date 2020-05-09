package com.example.loginwithgoogle.Menu.news.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.Network.ApiEndPoint;
import com.example.loginwithgoogle.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BeritaViewModel extends ViewModel {
    private MutableLiveData<ResponseBerita> mutableLiveData = new MutableLiveData<>();
    public void setDataBerita() {
        Retrofit retrofit = ApiService.getRetrofitServices();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<ResponseBerita> call = apiEndPoint.getBerita();
        call.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
               if (response.isSuccessful()){
                   boolean status=response.body().isStatus();
                   if (status){
                    List<BeritaItem> databerita=response.body().getBerita();
                    mutableLiveData.setValue((ResponseBerita) databerita);
                   }
               }

            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<ResponseBerita> getBerita() {
        return mutableLiveData;
    }
}
