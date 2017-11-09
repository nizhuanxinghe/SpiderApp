package com.example.chuwenbin.spiderapp.ui.mvp.presenter;

import android.content.Context;

import com.example.chuwenbin.spiderapp.ui.mvp.bean.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.IBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.ICapSheetBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class ICapSheetPresenter {
    private ICapSheetView mICapSheetView;
    private ICapSheetBiz mICapSheetBiz;
    private Context mContext;

    private GuitarSheetBean mGuitarSheetBean;


    public ICapSheetPresenter(ICapSheetView iCapSheetView) {
        this.mICapSheetView = iCapSheetView;
        mContext = mICapSheetView.getContext();
        mICapSheetBiz = new ICapSheetBiz(mContext);

    }

    public synchronized void capGuitarSheet() {
        LogUtil.d(">>>>>>>>>>>>>>>>>>>>>capGuitarSheet<<<<<<<<<<<<<<<<<<<<<<<");

        mICapSheetBiz.capGuitarSheet(mContext, new IBiz.RequestListener() {
            @Override
            public void onSuccess(Call call, Response response) {
                String respStr = response.body().toString();
                LogUtil.d("respStr:" + respStr);

                mGuitarSheetBean = new Gson().fromJson(respStr, GuitarSheetBean.class);

                mICapSheetView.showSheetList(mGuitarSheetBean);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(e.getMessage());
            }
        });
    }
}
