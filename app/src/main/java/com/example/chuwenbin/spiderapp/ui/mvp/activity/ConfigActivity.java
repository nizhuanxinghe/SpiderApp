package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chuwenbin.spiderapp.R;

public class ConfigActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEditRootUrl;
    private EditText mEditUrlClass;
    private EditText mEditHeadClass;
    private EditText mEditPageClass;
    private EditText mEditObjClass;

    private Button mBtnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        setContentView(R.layout.activity_config);

        mEditRootUrl = (EditText) findViewById(R.id.editText_rootUrl);
        mEditUrlClass = (EditText) findViewById(R.id.editText_urlClass);
        mEditHeadClass = (EditText) findViewById(R.id.editText_headTitle);
        mEditPageClass = (EditText) findViewById(R.id.editText_pageClass);
        mEditObjClass = (EditText) findViewById(R.id.editText_objClass);

        mBtnSave = (Button) findViewById(R.id.btn_saveConfig);

    }

    @Override
    void initController() {
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_saveConfig:

                break;
        }
    }
}
