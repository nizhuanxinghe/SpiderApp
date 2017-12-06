package com.example.chuwenbin.spiderapp.ui.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.PicsBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resq.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.IBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.ICapPicBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.biz.ICapSheetBiz;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.ui.mvp.view.IGetPicsView;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.example.chuwenbin.spiderapp.utils.ToastUtil;
import com.google.gson.Gson;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class ICapSheetPresenter {
    private ICapSheetView mICapSheetView;
    private IGetPicsView mIGetPicsView;
    private ICapSheetBiz mICapSheetBiz;
    private ICapPicBiz mICapPicBiz;
    private Context mContext;

    private GuitarSheetBean mGuitarSheetBean;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public ICapSheetPresenter(ICapSheetView iCapSheetView,IGetPicsView mIGetPicsView) {
        this.mICapSheetView = iCapSheetView;
        this.mIGetPicsView = mIGetPicsView;
        mContext = mICapSheetView.getContext();
        mICapSheetBiz = new ICapSheetBiz(mContext);
        mICapPicBiz = new ICapPicBiz(mContext);

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
                ToastUtil.showToast(errorMsg);
            }
        });
    }

    public synchronized void getPics(final SpiderRequestBean data) {
        LogUtil.d(">>>>>>>>>>>>>>>>>>>>>getPics<<<<<<<<<<<<<<<<<<<<<<<");

        mICapPicBiz.capPics(mContext, data, new IBiz.RequestListener() {
            @Override
            public void onSuccess(String resp) {

                LogUtil.d("respStr:" + resp);
                final PicsBean picsBean = new Gson().fromJson(resp, PicsBean.class);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIGetPicsView.showPicGrid(picsBean);
                    }
                });

            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtil.e(errorMsg);
                ToastUtil.showToast(errorMsg);
            }
        });
    }
}
