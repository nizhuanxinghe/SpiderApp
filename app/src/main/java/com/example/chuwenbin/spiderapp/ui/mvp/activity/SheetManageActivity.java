package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.adapter.SheetRecyclerAdapter;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.presenter.ICapSheetPresenter;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.utils.LogUtil;

public class SheetManageActivity extends BaseActivity implements ICapSheetView, View.OnClickListener {

    private RecyclerView mRCVSheetList;
    private Button mBtnCapSheet;

    private ICapSheetPresenter mICapSheetPresenter = new ICapSheetPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        setContentView(R.layout.activity_sheet_manage);

        mRCVSheetList = (RecyclerView) findViewById(R.id.recycler_guitarSheep);
        mBtnCapSheet = (Button) findViewById(R.id.btn_getSheet);

    }

    @Override
    void initController() {
        mBtnCapSheet.setOnClickListener(this);
    }

    @Override
    public void toActivity() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showSheetList(GuitarSheetBean data) {

        SheetRecyclerAdapter adapter = new SheetRecyclerAdapter(data, getLayoutInflater(), new SheetRecyclerAdapter.ItemSelectListener() {
            @Override
            public void onChecked(int index) {
                toActivity();
                LogUtil.d("checked:" + index);
            }
        });
        mRCVSheetList.setLayoutManager(new LinearLayoutManager(this));
        mRCVSheetList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getSheet:
                mICapSheetPresenter.capGuitarSheet();
                break;
        }
    }
}
