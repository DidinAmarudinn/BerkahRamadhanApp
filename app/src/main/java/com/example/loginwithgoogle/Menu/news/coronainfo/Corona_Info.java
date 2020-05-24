package com.example.loginwithgoogle.Menu.news.coronainfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;
import com.example.loginwithgoogle.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Corona_Info extends AppCompatActivity {
   private TextView tv_indo_positif,tv_indo_meninggal,tv_indo_sembuh,tv_world_positif,tv_world_sembuh,tv_world_meninggal;
   ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona__info);
        tv_indo_meninggal=findViewById(R.id.tv_indo_meninggal);
        tv_indo_positif=findViewById(R.id.tv_indo_positif);
        tv_world_meninggal=findViewById(R.id.tv_world_meninggal);
        tv_world_positif=findViewById(R.id.tv_indo_positif);
        tv_world_sembuh=findViewById(R.id.tv_world_sembuh);
        progressDialog=new ProgressDialog(this);
        tv_indo_sembuh=findViewById(R.id.tv_indo_sembuh);
       getDataIndoAll();
       getDataWorld();
    }

    public void getDataIndoAll(){
        IndonesiaViewModel viewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(IndonesiaViewModel.class);
        viewModel.setDataIndo();
        viewModel.getMutableLiveData().observe(this, new Observer<ResponseIndo>() {
            @Override
            public void onChanged(ResponseIndo responseIndo) {
                Log.d("jalan","responesIdn");
                tv_indo_positif.setText(responseIndo.getIdnConfirmed().getValue());
                tv_indo_meninggal.setText(responseIndo.getIdnDeaths().getValue());
                tv_indo_sembuh.setText(responseIndo.getIdnRecovered().getValue());
            }
        });

    }
    public void getDataWorld(){
        WorldViewModel viewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(WorldViewModel.class);
        viewModel.setMutableLiveData();
        viewModel.getMutableLiveData().observe(this, new Observer<ResponeWorld>() {
            @Override
            public void onChanged(ResponeWorld responeWorld) {
                tv_world_meninggal.setText(responeWorld.getDeaths().getValue());
                tv_world_positif.setText(responeWorld.getConfirmed().getValue());
                tv_world_sembuh.setText(responeWorld.getRecovered().getValue());
            }
        });
    }
}
