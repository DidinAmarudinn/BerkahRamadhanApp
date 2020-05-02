package com.example.loginwithgoogle.Menu.kiblat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.loginwithgoogle.R;

public class GPSTracker extends Service implements LocationListener {
    private final Context context;
    boolean isGPSEnabeld=false;
    boolean isNetworkEnabled=false;
    boolean canGetLocation=false;
    Location locaation;
    double latitude;
    double longtitude;
    //jarak minimal untuk berubah dalam meter
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES=100; //1 meter

    //minimal waktu antara update dalam second
    private static final long MIN_TIME_BW_UPDATES=1000*6*1; //1 menit

    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.context = context;
        getLocation();
    }
    @SuppressLint("MissingPermission")
    public Location getLocation(){
        try {
            locationManager=(LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabeld=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if (!isGPSEnabeld && !isNetworkEnabled){

            }else {
                this.canGetLocation=true;
                if (isNetworkEnabled){
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
                    Log.d("NETWORK", "getLocation: ");
                    if (locationManager !=null){
                        locaation=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (locaation !=null){
                            latitude=locaation.getLatitude();
                            longtitude=locaation.getLongitude();
                        }
                    }
                }
                if (isGPSEnabeld){
                    if (locaation!=null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
                        Log.d("GPS", "gpsEnabel: ");
                        if (locationManager!=null){
                            locaation=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (locaation!= null){
                                latitude=locaation.getLatitude();
                                longtitude=locaation.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locaation;
    }

    public void stopUsingGps(){
        if (locationManager != null){
            locationManager.removeUpdates(GPSTracker.this);
        }
    }
    public double getLatitude(){
        if (locaation!=null){
            latitude=locaation.getLatitude();
        }
        return latitude;
    }
    public double getLongtitude(){
        if (locaation!=null){
            longtitude=locaation.getLongitude();
        }
        return longtitude;
    }

    public boolean isCanGetLocation(){
        return this.canGetLocation;
    }

    public  void showingAlert(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
        //dialog title
        alertDialog.setTitle(context.getResources().getString(R.string.gps_settings_title));
        //dialog message
        alertDialog.setMessage(context.getResources().getString(R.string.gps_settings_text));

        alertDialog.setPositiveButton(context.getResources().getString(R.string.settings_button_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(context.getResources().getString(R.string.settings_button_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
    @Override
    public void onProviderDisabled(String provider) {
    }
}
