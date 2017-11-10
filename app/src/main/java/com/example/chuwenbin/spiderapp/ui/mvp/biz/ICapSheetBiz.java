package com.example.chuwenbin.spiderapp.ui.mvp.biz;

import android.content.Context;

import com.example.chuwenbin.spiderapp.net.RequestManager;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.utils.Config;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class ICapSheetBiz extends IBiz {

    private Context mContext;

    public ICapSheetBiz(Context context) {
        this.mContext = context;
    }

    public void capGuitarSheet(final Context context, SpiderRequestBean data, final RequestListener requestListener) {

//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        final Request request = new Request.Builder().url(Config.NetConfig.GET_GUITAR_SHEET_URL).build();
//        Call call = okHttpClient.newCall(request);
//
//        if (!NetworkUtil.isNetworkAvailable((Activity) context)) {
//            LogUtil.d("network error");
//            return;
//        }
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                requestListener.onFailure(call.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                requestListener.onSuccess(response);
//
//            }
//        });

        LogUtil.d("url:" + Config.NetConfig.GET_GUITAR_SHEET_URL);
        HashMap<String, String> params = new HashMap<>();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(data);
        params.put("data", jsonStr);
        RequestManager.getInstance(context).requestAsyn(Config.NetConfig.GET_GUITAR_SHEET_URL, RequestManager.TYPE_POST_JSON, params, new RequestManager.ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                requestListener.onSuccess(result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                requestListener.onFailure(errorMsg);
            }
        });
    }
}
