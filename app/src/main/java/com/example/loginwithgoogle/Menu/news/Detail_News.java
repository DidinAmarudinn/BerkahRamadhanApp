package com.example.loginwithgoogle.Menu.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.R;

public class Detail_News extends AppCompatActivity {
    TextView tv_detail_isi_berita,tv_detaul_judul_berita,tv_detail_tgl_berita;
    ImageView img_detail_berita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__news);
        tv_detail_isi_berita=findViewById(R.id.tv_detail_isi_berita);
        tv_detaul_judul_berita=findViewById(R.id.tv_detail_judul_berita);
        tv_detail_tgl_berita=findViewById(R.id.tv_deatil_tgl_berita);
        img_detail_berita=findViewById(R.id.img_detail_news);
        String judul_berita=getIntent().getExtras().getString("judul_berita");
        String isi_berita=getIntent().getExtras().getString("isi_berita");
        String tgl_berita=getIntent().getExtras().getString("tg_berita");
        String foto=getIntent().getExtras().getString("foto");
        tv_detail_tgl_berita.setText(tgl_berita);
        tv_detail_isi_berita.setText(isi_berita);
        tv_detaul_judul_berita.setText(judul_berita);
        final String url_gambar="http://192.168.43.231/apiberita/images/"+foto;
        Log.d("url_gambar",url_gambar);
        Glide.with(Detail_News.this).load(url_gambar).into(img_detail_berita);
    }
}
