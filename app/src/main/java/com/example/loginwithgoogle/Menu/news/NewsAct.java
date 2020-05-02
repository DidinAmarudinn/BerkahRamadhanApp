package com.example.loginwithgoogle.Menu.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;

import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.viewmodel.BeritaViewModel;
import com.example.loginwithgoogle.R;

import java.util.List;

public class NewsAct extends AppCompatActivity {
    private RecyclerView rv_berita;
    ProgressDialog progressDialog;
    BeritaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        progressDialog=new ProgressDialog(this);
        rv_berita=findViewById(R.id.rv_berita);
        adapter=new BeritaAdapter();
        rv_berita.setLayoutManager(new LinearLayoutManager(this));
        rv_berita.setHasFixedSize(true);
        rv_berita.setAdapter(adapter);
        loadData();

    }
    private void loadData(){
        BeritaViewModel viewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(BeritaViewModel.class);

        progressDialog.setTitle("Berita");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        viewModel.setDataBerita();
        viewModel.getBerita().observe(this, new Observer<List<BeritaItem>>() {
            @Override
            public void onChanged(List<BeritaItem> beritaItems) {
                adapter.setBerita(beritaItems);
                progressDialog.dismiss();
            }
        });

    }
}
