package com.ktad.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.analytics.sdk.Ads;
import com.analytics.sdk.activity.SplashActivity;
import com.analytics.sdk.inter.Listener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author : ssy
 * @date : 2018/12/22 16:08
 * @E-Mail ：1161209667@qq.com
 */
public class KunAd {
    private static KunAd instance = null;
    private static int timeout = 5000;
    private static Context context;
    private static String channel;
    private static Ads ads;

    private KunAd() { }

    public static KunAd getInstance(Context context,String channel) {
        KunAd.channel = channel;
        KunAd.context = context;
        if (instance == null) {
            synchronized (KunAd.class) {
                if (instance == null) {//2
                    instance = new KunAd();
                    ads = Ads.instance(context,channel);
                    getServerMsg(channel);
                }
            }
        }
        return instance;
    }
    public void setTimeout(int timeout) {
        KunAd.timeout = timeout;
        ads.setTimeout(timeout);// 设置广告超时时长，默认是 5000 毫秒
    }

    /*public void adSplashShow(Activity activity, Listener listener) {
        ads.adSplashShow(activity, listener);
    }*/

    public void adSplashShow(Activity activity, final KunListener listener) {
        ads.adSplashShow(activity, new ListenerProxy(listener));
    }

    private static void getServerMsg(String channel) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .add("channel",channel)
                .build();
        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Headers headers = response.headers();
//                for (int i = 0; i < headers.size(); i++) {
//                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
//                }
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });


    }

    public void onDestroy( Context context) {
        ads.onDestroy(context);
    }
}
