package com.example.loginwithgoogle.DatabaseLocal;

import android.content.Context;
import android.content.SharedPreferences;

public class Helper {

    private final String INTRO = "intro";
    private final String LATITUDE = "latitude";
    private final String LONGTITUDE = "longtitude";
    private final String CITY="city";
    private SharedPreferences preferences;
    private Context context;


    public Helper(Context context) {
        preferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(INTRO, loginorout);
        editor.commit();
    }

    public boolean getIsLogin() {
        return preferences.getBoolean(INTRO, false);
    }

    public void putLat(double loginorout) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(LATITUDE, String.valueOf(loginorout));
        edit.commit();
    }

    public String getLat() {
        return preferences.getString(LATITUDE, "");
    }
    public void putLang(double loginorout) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(LONGTITUDE, String.valueOf(loginorout));
        edit.commit();
    }

    public String getLong() {
        return preferences.getString(LONGTITUDE, "");
    }

    public void putCity(String loginorout){
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString(CITY,loginorout);
        edit.commit();
    }
    public String getCityy(){return preferences.getString(CITY,"");}

}
