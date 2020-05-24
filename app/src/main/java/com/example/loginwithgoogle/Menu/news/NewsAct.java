package com.example.loginwithgoogle.Menu.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginwithgoogle.Menu.news.ModelSlider.ResponseSlider;
import com.example.loginwithgoogle.Menu.news.coronainfo.Corona_Info;
import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.Network.ApiEndPoint;
import com.example.loginwithgoogle.Network.ApiService;
import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderPager;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsAct extends AppCompatActivity {
    private RecyclerView rv_berita;
    ProgressDialog progressDialog;
    List<BeritaItem> beritaItems=new ArrayList<>();
    BeritaAdapter adapter;
    ImageView btn_close_info;
    CardView card_info;
    SliderView sliderView;
    TextView tv_info_corona;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        toolbar = findViewById(R.id.toolbar);
        sliderView=findViewById(R.id.imageSlider);
        setSupportActionBar(toolbar);
        card_info=findViewById(R.id.card_info);
        btn_close_info=findViewById(R.id.btn_close_info);
        tv_info_corona=findViewById(R.id.tv_corona_info);
        card_info.setVisibility(View.VISIBLE);
        getSupportActionBar().setTitle("Berita Terbaru");
        BeritaAdapter beritaAdapter=new BeritaAdapter(beritaItems);
        rv_berita=findViewById(R.id.rv_berita);
        rv_berita.setLayoutManager(new LinearLayoutManager(this));
        rv_berita.setHasFixedSize(true);
        rv_berita.setAdapter(beritaAdapter);
        loadData();
        loadSlider();
        tv_info_corona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NewsAct.this, Corona_Info.class);
                startActivity(intent);
            }
        });
        btn_close_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_info.setVisibility(View.GONE);
            }
        });
    }
    private void loadData(){
        Retrofit retrofit= ApiService.getRetrofitServices();
        ApiEndPoint apiEndPoint=retrofit.create(ApiEndPoint.class);
        Call<ResponseBerita> call=apiEndPoint.getBerita();
        call.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()){
                    List<BeritaItem> beritaItems=response.body().getBerita();
                    boolean status=response.body().isStatus();
                    if (status){
                         new Handler().postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 BeritaAdapter beritaAdapter=new BeritaAdapter(beritaItems);
                                 beritaAdapter.shimerShow=false;
                                 beritaAdapter.notifyDataSetChanged();
                                 rv_berita.setAdapter(beritaAdapter);
                             }
                         },3000);
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });

    }
    public void loadSlider(){
        Retrofit retrofit= ApiService.getRetrofitServices();
        ApiEndPoint apiEndPoint=retrofit.create(ApiEndPoint.class);
        Call<ResponseSlider> call=apiEndPoint.getAllSlider();
        call.enqueue(new Callback<ResponseSlider>() {
            @Override
            public void onResponse(Call<ResponseSlider> call, Response<ResponseSlider> response) {
                List<com.example.loginwithgoogle.Menu.news.ModelSlider.BeritaItem> list=response.body().getBerita();
                boolean status=response.body().isStatus();
                if (status){
                        SliderAdapter sliderAdapter=new SliderAdapter(list);
                        sliderView.setSliderAdapter(sliderAdapter);
                        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
                        sliderView.setIndicatorSelectedColor(Color.WHITE);
                        sliderView.setIndicatorUnselectedColor(Color.GRAY);
                        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
                        sliderView.startAutoCycle();
                }

            }

            @Override
            public void onFailure(Call<ResponseSlider> call, Throwable t) {

            }
        });
    }

}
