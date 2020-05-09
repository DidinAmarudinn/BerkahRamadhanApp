package com.example.loginwithgoogle.Home;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginwithgoogle.DatabaseLocal.FavoriteDatabase;
import com.example.loginwithgoogle.DatabaseLocal.Helper;
import com.example.loginwithgoogle.Menu.JadwalShalat.Model.ResponeJadwal;
import com.example.loginwithgoogle.Menu.adzan.AdzanAct;
import com.example.loginwithgoogle.Menu.feeds.Feeds_Adapter;
import com.example.loginwithgoogle.Menu.feeds.model.FeedsItem;
import com.example.loginwithgoogle.Menu.feeds.model.ResponseFeeds;
import com.example.loginwithgoogle.Menu.kiblat.Compass;
import com.example.loginwithgoogle.Menu.kiblat.GPSTracker;
import com.example.loginwithgoogle.Menu.kiblat.KiblatAct;
import com.example.loginwithgoogle.Menu.news.NewsAct;
import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.Network.ApiEndPoint;
import com.example.loginwithgoogle.Network.ApiService;
import com.example.loginwithgoogle.NetworkPublic.ApiServicePublic;
import com.example.loginwithgoogle.NetworkPublic.EndPointPublic;
import com.example.loginwithgoogle.R;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";
    RelativeLayout kiblatAct, newsAct,adzan_menu;
    RecyclerView rv_feed;
    List<FeedsItem> feeds=new ArrayList<>();
    TextView tv_city, tv_waktu_shalat;
    SharedPreferences prefs;
    GPSTracker gps;
    Helper helper;
    private ProgressBar progressBar;
    public static FavoriteDatabase favoriteDatabase;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        kiblatAct = view.findViewById(R.id.kiblatAct);
        adzan_menu = view.findViewById(R.id.adzan_menu);
        newsAct = view.findViewById(R.id.newsAct);
        rv_feed = view.findViewById(R.id.rv_feed);
        tv_city = view.findViewById(R.id.tv_city);
        setupCompass();
        tv_waktu_shalat = view.findViewById(R.id.tv_waktu_shalat);
        helper = new Helper(getActivity());
        Feeds_Adapter adapter=new Feeds_Adapter(feeds,getContext());
        rv_feed.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_feed.setHasFixedSize(true);
        rv_feed.setAdapter(adapter);
        gps=new GPSTracker(getContext());
        favoriteDatabase = Room.databaseBuilder(getActivity(), FavoriteDatabase.class, "myfavdb").allowMainThreadQueries().build();
        loadData();
        kiblatAct.setOnClickListener(this);
        newsAct.setOnClickListener(this);
        adzan_menu.setOnClickListener(this);
        prefs= getActivity().getSharedPreferences("",Context.MODE_PRIVATE);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kiblatAct:
                Intent intent = new Intent(getActivity(), KiblatAct.class);
                startActivity(intent);
                break;
            case R.id.newsAct:
                Intent newsAct = new Intent(getActivity(), NewsAct.class);
                startActivity(newsAct);
                break;
            case R.id.adzan_menu:
                Intent adzanAct=new Intent(getActivity(), AdzanAct.class);
                startActivity(adzanAct);
                break;
        }
    }

    public void loadData() {
        Retrofit retrofit = ApiService.getRetrofitServices();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<ResponseFeeds> call = apiEndPoint.getAllFeeds();
        call.enqueue(new Callback<ResponseFeeds>() {
            @Override
            public void onResponse(Call<ResponseFeeds> call, Response<ResponseFeeds> response) {
                boolean status = response.body().isStatus();
                List<FeedsItem> feedsItems = response.body().getBerita();
                if (status) {
                    new  Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Feeds_Adapter feeds_adapter=new Feeds_Adapter(feedsItems,getContext());
                            rv_feed.setAdapter(feeds_adapter);
                            feeds_adapter.showShimmer=false;
                            feeds_adapter.notifyDataSetChanged();
                        }
                    },3000);
                }
            }
            @Override
            public void onFailure(Call<ResponseFeeds> call, Throwable t) {

            }
        });

    }

    public void getJadwalShalat(String city) {
        Retrofit retrofit = ApiServicePublic.getRetrofitServices();
        EndPointPublic endPointPublic = retrofit.create(EndPointPublic.class);
        Call<ResponeJadwal> call = endPointPublic.getJadwalDaily(city);
        call.enqueue(new Callback<ResponeJadwal>() {
            @Override
            public void onResponse(Call<ResponeJadwal> call, Response<ResponeJadwal> response) {
                if (response.isSuccessful()) {
                    //tv_city.setText(response.body().getCity().toString());
                   // tv_waktu_shalat.setText(response.body().getItems().get(0).getAsr());
                    String ashar=response.body().getItems().get(0).getAsr();
                    String maghrib=response.body().getItems().get(0).getMaghrib();
                    String isya=response.body().getItems().get(0).getIsha();
                    String subuh=response.body().getItems().get(0).getFajr();
                    String dzuhur=response.body().getItems().get(0).getDhuhr();
                    String city=response.body().getQuery();
                    helper.putCity(city);

                    DateFormat dateFormat=new SimpleDateFormat("hh:mm");
                    try {
                        Date date_ashar=dateFormat.parse(ashar);
                        Date date_magrib=dateFormat.parse(ashar);
                        Date date_isya=dateFormat.parse(ashar);
                        Date date_subuh=dateFormat.parse(ashar);
                        Date date_dzuhur=dateFormat.parse(ashar);
                        String jam_ashar=dateFormat.format(date_ashar);
                        Calendar calendar=Calendar.getInstance();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponeJadwal> call, Throwable t) {

            }
        });
    }
    public void getAddress(double lat, double longt) {
        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, longt, 1);
            if (addresses != null && addresses.size() > 0) {
                String addressLine = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String kab = addresses.get(0).getSubThoroughfare();
                String kec = addresses.get(0).getPremises();
                String ka = addresses.get(0).getSubAdminArea();
                tv_city.setText(ka);
                getJadwalShalat(city);
                Log.d(TAG, "country" + country);
                Log.d(TAG, "city" + city);
                Log.d(TAG, "admin area" + state);
                Log.d(TAG, "addresline" + addressLine);
                Log.d(TAG, "kec" + kec);
                Log.d(TAG, "kab" + kab);
                Log.d(TAG, "ka" + ka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setupCompass() {
        Boolean permission_granted = GetBoolean("permission_granted");
        if (permission_granted) {
            getBearing();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        }
    }
    @SuppressLint("MissingPermission")
    public void getBearing() {
        // Get the location manager
           fetch_GPS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SaveBoolean("permission_granted", true);

                } else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.toast_permission_required), Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void fetch_GPS() {
        double result = 0;
        gps = new GPSTracker(getContext());
        if (gps.isCanGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongtitude();
            Log.d(TAG,"lat"+latitude);
            Log.d(TAG,"lomh"+longitude);
            getAddress(latitude,longitude);
            // \n is for new line
        }else
        {
            gps.showingAlert();
        }

    }
    public  void SaveBoolean(String Judul, Boolean bbb){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putBoolean(Judul, bbb);
        edit.apply();
    }
    public Boolean GetBoolean(String Judul){
        prefs= getActivity().getSharedPreferences("",Context.MODE_PRIVATE);
        Boolean result = prefs.getBoolean(Judul, false);
        return result;
    }
}
