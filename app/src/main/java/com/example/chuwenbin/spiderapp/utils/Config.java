package com.example.chuwenbin.spiderapp.utils;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class Config {

    public static final String ROOT_URL = "http://10.0.0.121:8000/";

    public static class NetConfig{
        public static final String GET_GUITAR_SHEET_URL = ROOT_URL + "server/getGuitarSheet";
        public static final String GET_PICS_URL = ROOT_URL + "server/getSheetImg";
    }

    public static class PreferenceConfig{
        public static final String SETTING_PARAM = "SETTING_PARAM";

        public static final String KEY_ROOT_URL = "KEY_ROOT_URL";
        public static final String KEY_URL_TAG = "KEY_URL_CLASS";
        public static final String KEY_PAGE_TITLE = "KEY_HEAD_CLASS";
        public static final String KEY_PAGE_CLASS = "KEY_PAGE_CLASS";
        public static final String KEY_OBJ_CLASS = "KEY_OBJ_CLASS";
        public static final String KEY_OBJ_TAB_CLASS = "KEY_OBJ_TAB_CLASS";
    }
}
