package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.chuwenbin.spiderapp.MyApplication;
import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.model.DialogHintInfo;
import com.example.chuwenbin.spiderapp.ui.widget.dialog.HintDialogUtil;
import com.example.chuwenbin.spiderapp.utils.Config;
import com.example.chuwenbin.spiderapp.utils.PreferenceUtils;

import java.util.HashMap;
import java.util.Map;

public class ConfigActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEditRootUrl;
    private EditText mEditUrlClass;
    private EditText mEditHeadClass;
    private EditText mEditPageClass;
    private EditText mEditObjClass;
    private EditText mEditObjTabClass;

    private Button mBtnSave;
    private ImageView mBtnBack;


    private boolean isSave = false;

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
        mEditObjTabClass = (EditText) findViewById(R.id.editText_objTabClass);

        mBtnSave = (Button) findViewById(R.id.btn_saveConfig);
        mBtnBack = (ImageView) findViewById(R.id.btn_back);


        mEditRootUrl.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_ROOT_URL));
        mEditUrlClass.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_URL_TAG));
        mEditHeadClass.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_PAGE_TITLE));
        mEditPageClass.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_PAGE_CLASS));
        mEditObjClass.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_OBJ_CLASS));
        mEditObjTabClass.setText(PreferenceUtils.getString(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, Config.PreferenceConfig.KEY_OBJ_TAB_CLASS));
    }

    @Override
    void initController() {
        mBtnSave.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_saveConfig:
                saveConfigParams();
                break;
            case R.id.btn_back:
                actionBack();
                break;
        }
    }

    private void actionBack() {
        if (isSave){
            finish();
            return;
        }
        HintDialogUtil hintDialogUtil = new HintDialogUtil();
        DialogHintInfo info = new DialogHintInfo("温馨提示","您还没有保存设置，是否退出？","取消","确定");
        hintDialogUtil.showDialog(this,info,HintDialogUtil.WARNING);
        hintDialogUtil.setDialogListener(new HintDialogUtil.DialogListener() {
            @Override
            public void onClick(boolean isOk) {
                if (isOk){
                    finish();
                    return;
                }
            }
        });
    }

    private void saveConfigParams() {
        String root_url = mEditRootUrl.getText().toString();
        String url_class = mEditUrlClass.getText().toString();
        String head_class = mEditHeadClass.getText().toString();
        String page_class = mEditPageClass.getText().toString();
        String obj_class = mEditObjClass.getText().toString();
        String obj_tab_class = mEditObjTabClass.getText().toString();

        Map<String, String> params = new HashMap<>();
        params.put(Config.PreferenceConfig.KEY_ROOT_URL, root_url);
        params.put(Config.PreferenceConfig.KEY_URL_TAG, url_class);
        params.put(Config.PreferenceConfig.KEY_PAGE_TITLE, head_class);
        params.put(Config.PreferenceConfig.KEY_PAGE_CLASS, page_class);
        params.put(Config.PreferenceConfig.KEY_OBJ_CLASS, obj_class);
        params.put(Config.PreferenceConfig.KEY_OBJ_TAB_CLASS,obj_tab_class);

        PreferenceUtils.insertDatas(MyApplication.getInstances(), Config.PreferenceConfig.SETTING_PARAM, params);

        isSave = true;

        DialogHintInfo info = new DialogHintInfo();
        info.setTitle("温馨提示");
        info.setContent("设置保存成功");
        HintDialogUtil.showDialog(this, info, HintDialogUtil.SUCCESS);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            actionBack();
        }
        return super.onKeyDown(keyCode, event);
    }
}
