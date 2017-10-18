package com.jiyun.day01_homework.httputils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by asus on 2017/10/17.
 */

public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient client;
    private OkHttpUtils(){
        client = new OkHttpClient.Builder().build();
    }
    public static synchronized OkHttpUtils getInstance(){
        if (okHttpUtils== null)
            okHttpUtils =new OkHttpUtils();
        return okHttpUtils;
    }
    public void sendGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
