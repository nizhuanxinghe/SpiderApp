package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.adapter.SheetRecyclerAdapter;
import com.example.chuwenbin.spiderapp.ui.adapter.SpaceItemDecoration;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.ui.mvp.presenter.ICapSheetPresenter;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.utils.DeviceUtil;
import com.example.chuwenbin.spiderapp.utils.LogUtil;

public class SheetManageActivity extends BaseActivity implements ICapSheetView, View.OnClickListener {

    private RecyclerView mRCVSheetList;
    private Button mBtnCapSheet;
    private EditText mEditRootUrl;

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
        mEditRootUrl = (EditText) findViewById(R.id.editText_rootUrl);

        mRCVSheetList.addItemDecoration(new SpaceItemDecoration(30));

    }

    @Override
    void initController() {
        mBtnCapSheet.setOnClickListener(this);
    }


    @Override
    public void toActivity(GuitarSheetBean.DataList data) {
        Intent intent = new Intent(SheetManageActivity.this, SheetWebActivity.class);
        intent.putExtra("link", data.getLink());
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showSheetList(final GuitarSheetBean data) {

        LogUtil.d(">>>>>>>>>>>>>>>>>>>>>>>>>>showSheetList<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        LogUtil.d(data + "");

        SheetRecyclerAdapter adapter = new SheetRecyclerAdapter(data, getLayoutInflater(), new SheetRecyclerAdapter.ItemSelectListener() {
            @Override
            public void onChecked(int index) {
                toActivity(data.getDataList().get(index));
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
                SpiderRequestBean data = new SpiderRequestBean();
                data.setMacAddress(DeviceUtil.getLocalMacAddress(this));
                data.setRootUrl(mEditRootUrl.getText().toString());
                mICapSheetPresenter.capGuitarSheet(data);
                break;
        }
    }
}
