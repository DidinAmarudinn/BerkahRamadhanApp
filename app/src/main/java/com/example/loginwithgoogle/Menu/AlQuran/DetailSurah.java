package com.example.loginwithgoogle.Menu.AlQuran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.loginwithgoogle.Menu.AlQuran.Adapter.AyatAdapter;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.AyahsItem;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.Data;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.ResponseAyat;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.Text;
import com.example.loginwithgoogle.NetworkPublic.ApiPublic;
import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;
import com.example.loginwithgoogle.R;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailSurah extends AppCompatActivity {
    Toolbar toolbar_surah;
    TextView tv_titlle_layout;
    RecyclerView rv_ayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surah);
        toolbar_surah=findViewById(R.id.toolbar_surah);
        setSupportActionBar(toolbar_surah);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title_ayout=getIntent().getExtras().getString("nameSurah");
        String numberSurah=getIntent().getExtras().getString("numbersurah");
        tv_titlle_layout=findViewById(R.id.tv_title_layout);
        tv_titlle_layout.setText(title_ayout);
        Retrofit retrofit= ApiServicePublic.getRetrofitServicesAll(ApiPublic.BASE_URL_ALQURAN);
        EndPointPublic endPointPublic=retrofit.create(EndPointPublic.class);
        Call<ResponseAyat> call=endPointPublic.getAyat(numberSurah);
        rv_ayat=findViewById(R.id.rv_ayat);
        rv_ayat.setLayoutManager(new LinearLayoutManager(this));
        rv_ayat.setHasFixedSize(true);
        getDataAyat(call);

    }
    public void  getDataAyat(Call<ResponseAyat> call) {
    call.enqueue(new Callback<ResponseAyat>() {
        @Override
        public void onResponse(Call<ResponseAyat> call, Response<ResponseAyat> response) {
           if (response.isSuccessful()){
               List<AyahsItem> ayahsItems=response.body().getData().getAyahs();
               Data data=response.body().getData();
               FragmentManager fragmentManager=getSupportFragmentManager();
               AyatAdapter ayatAdapter=new AyatAdapter(DetailSurah.this,ayahsItems,data);
               rv_ayat.setAdapter(ayatAdapter);
           }

        }

        @Override
        public void onFailure(Call<ResponseAyat> call, Throwable t) {

        }
    });
    }
}
