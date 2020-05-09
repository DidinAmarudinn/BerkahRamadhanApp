package com.example.loginwithgoogle.Menu.adzan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.loginwithgoogle.DatabaseLocal.Helper;
import com.example.loginwithgoogle.Menu.JadwalShalat.Model.ResponeJadwal;
import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;
import com.example.loginwithgoogle.R;

import java.lang.annotation.Retention;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
public class AdzanAct extends AppCompatActivity {
    TextView tv_alamat,tv_subuh,tv_dzuhur,tv_ashar,tv_maghrib,tv_isya,tv_date;
    Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adzan);
        tv_alamat=findViewById(R.id.tv_alamat);
        helper=new Helper(this);
        tv_ashar=findViewById(R.id.tv_ashar);
        tv_date=findViewById(R.id.tv_date);
        tv_maghrib=findViewById(R.id.tv_maghrib);
        tv_isya=findViewById(R.id.tv_isya);
        tv_subuh=findViewById(R.id.tv_subuh);
        tv_dzuhur=findViewById(R.id.tv_dzuhur);
        loadData();
    }

    public void loadData(){
        Retrofit retrofit= ApiServicePublic.getRetrofitServices();
        EndPointPublic endPointPublic=retrofit.create(EndPointPublic.class);
        String city=helper.getCityy();
        Call<ResponeJadwal> call=endPointPublic.getJadwalDaily(city);
        call.enqueue(new Callback<ResponeJadwal>() {
            @Override
            public void onResponse(Call<ResponeJadwal> call, Response<ResponeJadwal> response) {
                if (response.isSuccessful()){
                    tv_date.setText(response.body().getItems().get(0).getDateFor());
                    tv_alamat.setText(response.body().getAddress());
                    tv_ashar.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isya.setText(response.body().getItems().get(0).getIsha());
                    tv_subuh.setText(response.body().getItems().get(0).getFajr());
                    tv_dzuhur.setText(response.body().getItems().get(0).getDhuhr());
                }
            }
            @Override
            public void onFailure(Call<ResponeJadwal> call, Throwable t) {

            }
        });
    }


}
