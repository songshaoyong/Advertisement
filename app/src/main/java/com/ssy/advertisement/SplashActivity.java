package com.ssy.advertisement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ktad.sdk.KunAd;
import com.ktad.sdk.KunListener;

public class SplashActivity extends AppCompatActivity {
    private KunAd ads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initSDK();
    }

    public void initSDK() {
        ads = KunAd.getInstance(this, "你的渠道号");
        ads.setTimeout(5000);
        ads.adSplashShow(this, new KunListener() {
            @Override
            public void onAdFailed(String msg) {
                System.out.println(msg);
            }

            @Override
            public void onCancel() {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onClick() {
                ads.onDestroy(SplashActivity.this);
            }

            @Override
            public void onExp() {

            }

            @Override
            public void onStartDownload() {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
            }
        });

  /*      ads.adIntervalShow(MainActivity.this, new Listener() {
            @Override
            public void onAdFailed(String msg) {
                System.out.println(msg);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onClick() {

            }

            @Override
            public void onExp() {

            }

            @Override
            public void onStartDownload() {

            }
        });*/

//        setUpSplash();
    }
}
