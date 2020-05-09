package com.example.loginwithgoogle.Menu.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toolbar;

import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.Menu.news.viewmodel.BeritaViewModel;
import com.example.loginwithgoogle.Network.ApiEndPoint;
import com.example.loginwithgoogle.Network.ApiService;
import com.example.loginwithgoogle.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsAct extends AppCompatActivity {
    private RecyclerView rv_berita;
    ProgressDialog progressDialog;
    BeritaAdapter adapter;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Berita Terbaru");
        progressDialog=new ProgressDialog(this);
        rv_berita=findViewById(R.id.rv_berita);
        rv_berita.setLayoutManager(new LinearLayoutManager(this));
        rv_berita.setHasFixedSize(true);
        loadData();
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
                            BeritaAdapter beritaAdapter=new BeritaAdapter(beritaItems);
                            rv_berita.setAdapter(beritaAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });

    }
}
