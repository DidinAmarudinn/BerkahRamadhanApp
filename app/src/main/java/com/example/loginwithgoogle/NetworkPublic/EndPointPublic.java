package com.example.loginwithgoogle.NetworkPublic;

import com.example.loginwithgoogle.Menu.JadwalShalat.Model.ResponeJadwal;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPointPublic {
    @GET("{Location}/daily.json")
    Call<ResponeJadwal> getJadwalDaily(@Path("Location") String location);
    @GET("{Location}/weekly.json")
    Call<ResponeJadwal> getJadwalWeekly(@Path("Location") String loctionname);
}
