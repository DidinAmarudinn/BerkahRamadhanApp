package com.example.loginwithgoogle.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginwithgoogle.Home.DashboardAct;
import com.example.loginwithgoogle.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_signin,btn_signup;
    private GoogleSignInClient mGoogleSignInClient;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_signin=findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(this);
        btn_signup=findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    @Override
        protected void onStart() {
            super.onStart();

        }
        @Override
         public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                Intent signin=new Intent(MainActivity.this, DashboardAct.class);
                startActivity(signin);
                break;
            case R.id.btn_signup:
                Intent signup=new Intent(MainActivity.this,RegistAct.class);
                startActivity(signup);
                break;
        }
    }


    }
