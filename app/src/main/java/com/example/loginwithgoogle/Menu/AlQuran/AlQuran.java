package com.example.loginwithgoogle.Menu.AlQuran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.loginwithgoogle.Menu.AlQuran.Adapter.SurahAdapter;
import com.example.loginwithgoogle.Menu.AlQuran.model.DataItem;
import com.example.loginwithgoogle.Menu.AlQuran.model.ResponseSurah;
import com.example.loginwithgoogle.NetworkPublic.ApiPublic;
import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;
import com.example.loginwithgoogle.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AlQuran extends AppCompatActivity {
    RecyclerView rv_surah;
    ProgressDialog loadingData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_quran);
        rv_surah=findViewById(R.id.rv_surah);
        rv_surah.setLayoutManager(new LinearLayoutManager(this));
        rv_surah.setHasFixedSize(true);
        loadingData = new ProgressDialog(this);
        loadingData.setTitle("Mohon tunggu...");
        loadingData.setCancelable(false);
        loadingData.setMessage("Sedang mengambil data dari API");
        loadData();

    }
    public void loadData(){
        loadingData.show();
        Retrofit retrofit=ApiServicePublic.getRetrofitServicesAll(ApiPublic.BASE_URL_ALQURAN);
        EndPointPublic endPointPublic=retrofit.create(EndPointPublic.class);
        Call<ResponseSurah> call=endPointPublic.getSurahData();
        call.enqueue(new Callback<ResponseSurah>() {
            @Override
            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
                List<DataItem> dataItems=response.body().getData();
                if (response.isSuccessful()){
                    loadingData.dismiss();
                    SurahAdapter surahAdapter=new SurahAdapter(dataItems,AlQuran.this);
                    rv_surah.setAdapter(surahAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseSurah> call, Throwable t) {

            }
        });
    }



}
