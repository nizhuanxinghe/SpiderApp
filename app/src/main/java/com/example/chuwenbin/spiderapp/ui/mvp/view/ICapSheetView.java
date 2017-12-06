package com.example.chuwenbin.spiderapp.ui.mvp.view;

import android.content.Context;

import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.GuitarSheetBean;

/**
 * Created by chuwenbin on 17/11/9.
 */

public interface ICapSheetView{
    void toSheetWebActivity(GuitarSheetBean.DataList data);
    Context getContext();

    void showSheetList(GuitarSheetBean data);
}
