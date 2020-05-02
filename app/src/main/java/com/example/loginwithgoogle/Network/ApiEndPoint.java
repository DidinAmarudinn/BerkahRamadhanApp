package com.example.loginwithgoogle.Network;

import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET(Api.END_POINT_BERITA)
    Call<BeritaItem> getBerita();
}
