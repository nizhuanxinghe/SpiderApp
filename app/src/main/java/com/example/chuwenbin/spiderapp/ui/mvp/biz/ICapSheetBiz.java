package com.example.chuwenbin.spiderapp.ui.mvp.biz;

import android.app.Activity;
import android.content.Context;

import com.example.chuwenbin.spiderapp.utils.Config;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.example.chuwenbin.spiderapp.utils.NetworkUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class ICapSheetBiz extends IBiz {

    private Context mContext;

    public ICapSheetBiz(Context context) {
        this.mContext = context;
    }

    public void capGuitarSheet(final Context context, final RequestListener requestListener) {

        OkHttpClient okHttpClient = new OkHttpClient();

        LogUtil.d("url:" + Config.NetConfig.GET_GUITAR_SHEET_URL);

        final Request request = new Request.Builder().url(Config.NetConfig.GET_GUITAR_SHEET_URL).build();

        Call call = okHttpClient.newCall(request);

        if(!NetworkUtil.isNetworkAvailable((Activity) context)){
            LogUtil.d("network error");
            return;
        }
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                requestListener.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                requestListener.onSuccess(call, response);

            }
        });
    }
}
