package com.example.chuwenbin.spiderapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by pax1 on 17/4/1.
 */

public class PreferenceUtils {

    public static String getString(Context context, String name, String key) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    public static void insertData(Context context, String name, String key, Object param) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (param instanceof Boolean) {
            editor.putBoolean(key, (Boolean) param);
        }
        else if (param instanceof String) {
            editor.putString(key, (String) param);
        }
        else if (param instanceof Integer) {
            editor.putInt(key, (Integer) param);
        }
        else if (param instanceof Long) {
            editor.putLong(key, (Long) param);
        }
        else if (param instanceof Float || param instanceof Double) {
            editor.putFloat(key, (Float) param);
        }
        editor.commit();
    }

    public static void insertDatas(Context context, String name, Map<String, String> params) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for (String key : params.keySet()) {
            String value = params.get(key);
            editor.putString(key, value);
        }
        editor.commit();
    }

}
