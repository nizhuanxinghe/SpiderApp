package com.example.chuwenbin.spiderapp.ui.mvp.biz;

import android.content.Context;

import com.example.chuwenbin.spiderapp.net.RequestManager;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resq.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.utils.Config;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by chuwenbin on 17/12/5.
 */

public class ICapPicBiz {

    private Context mContext;

    public ICapPicBiz(Context context) {
        this.mContext = context;
    }

    public void capPics(final Context context, SpiderRequestBean data, final IBiz.RequestListener requestListener) {

        LogUtil.d("url:" + Config.NetConfig.GET_PICS_URL);
        HashMap<String, String> params = new HashMap<>();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(data);
        params.put("data", jsonStr);
        LogUtil.d(jsonStr);
        RequestManager.getInstance(context).requestAsyn(Config.NetConfig.GET_PICS_URL, RequestManager.TYPE_POST_JSON, params, new RequestManager.ReqCallBack<String>() {

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
