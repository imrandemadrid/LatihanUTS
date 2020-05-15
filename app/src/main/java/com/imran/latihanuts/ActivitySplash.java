package com.imran.latihanuts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
    Mohamad Imran 10117170 IF5
    Tanggal pengerjaan Sabtu 9 Mei 2020
 */

public class ActivitySplash extends AppCompatActivity {

    private int DELAY_SPLASH = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ActivitySplash.this, ViewPagerActivity.class));
            }
        }, DELAY_SPLASH);
    }
}
