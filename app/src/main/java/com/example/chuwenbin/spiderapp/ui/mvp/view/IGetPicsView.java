package com.example.chuwenbin.spiderapp.ui.mvp.view;

import android.content.Context;

import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.PicsBean;

/**
 * Created by chuwenbin on 2017/12/6.
 */

public interface IGetPicsView {
    Context getContext();
    void showPicGrid(PicsBean data);
}
