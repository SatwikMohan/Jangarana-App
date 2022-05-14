package com.woc.jangarana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.woc.jangarana.authentication.LoginOptionsActivity;
import com.woc.jangarana.familyhead.DashboardActivity;

public class SplashScreen extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        sharedPreferences = getSharedPreferences("Head SignUp", MODE_PRIVATE);


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (!sharedPreferences.getString("family_head_token" , "").equalsIgnoreCase("") )
                {
                    Intent intent=new Intent(SplashScreen.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else startActivity(new Intent(SplashScreen.this, LoginOptionsActivity.class));
            }
        };
        handler.postDelayed(runnable,2000);


    }
}