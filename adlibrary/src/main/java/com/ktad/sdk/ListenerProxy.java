package com.ktad.sdk;

import com.analytics.sdk.inter.Listener;

/**
 * @author : ssy
 * @date : 2018/12/22 17:36
 * @E-Mail ：1161209667@qq.com
 */
public class ListenerProxy implements Listener {


    private final KunListener listener;

    public ListenerProxy(KunListener listener) {
        this.listener = listener;
    }

    @Override
    public void onAdFailed(String s) {
        listener.onAdFailed(s);
    }

    @Override
    public void onCancel() {
        listener.onCancel();
    }

    @Override
    public void onSuccess() {
        listener.onSuccess();
    }

    @Override
    public void onClick() {
        listener.onClick();
    }

    @Override
    public void onExp() {
        listener.onExp();
    }

    @Override
    public void onStartDownload() {
        listener.onStartDownload();
    }
}
