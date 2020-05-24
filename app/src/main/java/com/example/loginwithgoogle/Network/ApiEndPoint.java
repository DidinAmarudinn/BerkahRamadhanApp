package com.example.loginwithgoogle.Network;

import com.example.loginwithgoogle.Menu.feeds.model.ResponseFeeds;
import com.example.loginwithgoogle.Menu.news.ModelSlider.ResponseSlider;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET(Api.END_POINT_BERITA)
    Call<ResponseBerita> getBerita();

    @GET(Api.END_POINT_FEED)
    Call<ResponseFeeds> getAllFeeds();

    @GET(Api.END_POINT_SLIDER)
    Call<ResponseSlider> getAllSlider();
}
