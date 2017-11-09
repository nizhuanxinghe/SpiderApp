package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.chuwenbin.spiderapp.utils.ToastUtil;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        ToastUtil.regist(this.getApplicationContext());

        initData();

        initView();

        initController();
    }

    abstract void initData();
    abstract void initView();
    abstract void initController();

}
