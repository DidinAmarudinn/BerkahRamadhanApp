package com.example.loginwithgoogle.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.loginwithgoogle.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardAct extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bn_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bn_main=findViewById(R.id.bn_main);
        lodaFragment(new HomeFragment());
        bn_main.setOnNavigationItemSelectedListener(this);
    }
    private boolean lodaFragment(Fragment fragment){
        if (fragment !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment).commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment=new HomeFragment();
        }
        return lodaFragment(fragment);
    }
}
