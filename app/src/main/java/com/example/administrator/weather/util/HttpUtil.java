package com.example.administrator.weather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 使用okHttp开源框架访问网络，发送网络请求只需调用sendOkHttpRequest方法
 * 传入url地址，并注册回调来处理服务器响应
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
