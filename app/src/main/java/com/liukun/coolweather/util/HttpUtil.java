package com.liukun.coolweather.util;


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Author: liukun on 2020/4/27.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
