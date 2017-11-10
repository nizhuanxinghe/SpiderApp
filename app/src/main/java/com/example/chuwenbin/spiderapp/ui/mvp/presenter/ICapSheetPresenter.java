package com.example.chuwenbin.spiderapp.ui.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.chuwenbin.spiderapp.ui.mvp.bean.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.IBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.ICapSheetBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.google.gson.Gson;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class ICapSheetPresenter {
    private ICapSheetView mICapSheetView;
    private ICapSheetBiz mICapSheetBiz;
    private Context mContext;

    private GuitarSheetBean mGuitarSheetBean;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public ICapSheetPresenter(ICapSheetView iCapSheetView) {
        this.mICapSheetView = iCapSheetView;
        mContext = mICapSheetView.getContext();
        mICapSheetBiz = new ICapSheetBiz(mContext);

    }

    public synchronized void capGuitarSheet(SpiderRequestBean data) {
        LogUtil.d(">>>>>>>>>>>>>>>>>>>>>capGuitarSheet<<<<<<<<<<<<<<<<<<<<<<<");

        mICapSheetBiz.capGuitarSheet(mContext, data, new IBiz.RequestListener() {
            @Override
            public void onSuccess(String resp) {

                LogUtil.d("respStr:" + resp);

                mGuitarSheetBean = new Gson().fromJson(resp, GuitarSheetBean.class);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mICapSheetView.showSheetList(mGuitarSheetBean);
                    }
                });

            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtil.e(errorMsg);
            }
        });
    }
}
