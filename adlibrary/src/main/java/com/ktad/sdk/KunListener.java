package com.ktad.sdk;

import com.analytics.sdk.inter.Listener;

public interface KunListener  {

    void onAdFailed(String var1);

    void onCancel();

    void onSuccess();

    void onClick();

    void onExp();

    void onStartDownload();




}