package com.example.loginwithgoogle.NetworkPublic;

import com.example.loginwithgoogle.Menu.AlQuran.model.ResponseSurah;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.ResponseAyat;
import com.example.loginwithgoogle.Menu.JadwalShalat.Model.ResponeJadwal;
import com.example.loginwithgoogle.Menu.news.coronainfo.ResponeWorld;
import com.example.loginwithgoogle.Menu.news.coronainfo.ResponseIndo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPointPublic {
    @GET("{Location}/daily.json")
    Call<ResponeJadwal> getJadwalDaily(@Path("Location") String location);


    @GET("{Location}/weekly.json")
    Call<ResponeJadwal> getJadwalWeekly(@Path("Location") String loctionname);


    @GET(ApiPublic.END_INDONESIA)
    Call<ResponseIndo> getIndoneisaStats();


    @GET(ApiPublic.END_POINT_SUMMARY_WORLD)
    Call<ResponeWorld> getSummaryWorld();

    @GET(ApiPublic.END_SURAH)
    Call<ResponseSurah> getSurahData();

    @GET(ApiPublic.END_SURAH+"{surah}")
    Call<ResponseAyat> getAyat(@Path("surah") String numberSurah);


}
