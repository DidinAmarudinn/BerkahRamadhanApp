package com.example.loginwithgoogle.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginwithgoogle.R;

public class LoginAct extends AppCompatActivity implements View.OnClickListener {
    private Button btn_signin,btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_signin=findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(this);
        btn_signup=findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                break;
            case R.id.btn_signup:
                Intent signup=new Intent(LoginAct.this,RegistAct.class);
                startActivity(signup);
                break;
        }
    }
}
