package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chuwenbin.spiderapp.MyApplication;
import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.adapter.PicRecyclerAdapter;
import com.example.chuwenbin.spiderapp.ui.adapter.SheetRecyclerAdapter;
import com.example.chuwenbin.spiderapp.ui.adapter.SpaceItemDecoration;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.PicsBean;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resq.SpiderRequestBean;
import com.example.chuwenbin.spiderapp.ui.mvp.presenter.ICapSheetPresenter;
import com.example.chuwenbin.spiderapp.ui.mvp.view.ICapSheetView;
import com.example.chuwenbin.spiderapp.ui.mvp.view.IGetPicsView;
import com.example.chuwenbin.spiderapp.utils.Config;
import com.example.chuwenbin.spiderapp.utils.DeviceUtil;
import com.example.chuwenbin.spiderapp.utils.LogUtil;
import com.example.chuwenbin.spiderapp.utils.PreferenceUtils;
import com.example.chuwenbin.spiderapp.utils.ToastUtil;

public class SheetManageActivity extends BaseActivity implements ICapSheetView, IGetPicsView, View.OnClickListener {

    private static final String ACTION_GET_SHEET = "ACTION_GET_SHEET";
    private static final String ACTION_GET_PICS = "ACTION_GET_PICS";

    private RecyclerView mRCVSheetList;
    private Button mBtnCapSheet;
    private TextView mBtnConfig;
    private EditText mEditContent;

    private RadioButton mRBtnGetSheet;
    private RadioButton mRBtnGetPic;

    private ICapSheetPresenter mICapSheetPresenter = new ICapSheetPresenter(this, this);

    @Override
    void initData() {

    }

    @Override
    void initView() {
        setContentView(R.layout.activity_sheet_manage);

        mRCVSheetList = (RecyclerView) findViewById(R.id.recycler_guitarSheep);
        mBtnCapSheet = (Button) findViewById(R.id.btn_getSheet);
        mEditContent = (EditText) findViewById(R.id.editText_sheet);
        mRBtnGetPic = (RadioButton) findViewById(R.id.radio_pic);
        mRBtnGetSheet = (RadioButton) findViewById(R.id.radio_sheet);

        mBtnConfig = (TextView) findViewById(R.id.textView_config);

        mRCVSheetList.addItemDecoration(new SpaceItemDecoration(30));

    }

    @Override
    void initController() {
        mBtnCapSheet.setOnClickListener(this);
        mBtnConfig.setOnClickListener(this);
    }


    @Override
    public void toSheetWebActivity(GuitarSheetBean.DataList data) {
        Intent intent = new Intent(SheetManageActivity.this, SheetWebActivity.class);
        intent.putExtra("link", data.getLink());
        startActivity(intent);
    }

    private void toActivity(Class _class) {
        startActivity(new Intent(SheetManageActivity.this, _class));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showPicGrid(PicsBean data) {
        PicRecyclerAdapter adapter = new PicRecyclerAdapter(data, getLayoutInflater(), new PicRecyclerAdapter.ItemSelectListener() {
            @Override
            public void onChecked(int index) {
                ToastUtil.showToast("checked:" + index);
            }
        });
        mRCVSheetList.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRCVSheetList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSheetList(final GuitarSheetBean data) {

        LogUtil.d(">>>>>>>>>>>>>>>>>>>>>>>>>>showSheetList<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        SheetRecyclerAdapter adapter = new SheetRecyclerAdapter(data, getLayoutInflater(), new SheetRecyclerAdapter.ItemSelectListener() {
            @Override
            public void onChecked(int index) {
                toSheetWebActivity(data.getDataList().get(index));
                ToastUtil.showToast("checked:" + index);
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
                data.setFilter(mEditContent.getText().toString());
                data.setRootUrl(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_ROOT_URL));
                data.setUrlTag(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_URL_TAG));
                data.setPageClass(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_PAGE_CLASS));
                data.setPageTitle(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_PAGE_TITLE));
                data.setObjClass(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_OBJ_CLASS));
                data.setObjTagClass(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_OBJ_TAB_CLASS));

                if (mRBtnGetPic.isChecked()) {
                    data.setAction(ACTION_GET_PICS);
                    mICapSheetPresenter.getPics(data);
                }
                else {
                    data.setAction(ACTION_GET_SHEET);
                    mICapSheetPresenter.capGuitarSheet(data);
                }
                break;
            case R.id.textView_config:
                toActivity(ConfigActivity.class);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        Glide.get(this).clearMemory(); //clear the cache from glide
        super.onDestroy();
    }
}
