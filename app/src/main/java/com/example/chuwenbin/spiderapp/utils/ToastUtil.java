package com.example.chuwenbin.spiderapp.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	private static Toast mToast = null;
	 
    private static long lastClickTime;
    private static Context mContext;
    private static boolean show = true;
    
    public static void regist(Context context){
    	mContext = context;
    	mToast = Toast.makeText(mContext, "",
                Toast.LENGTH_SHORT);
    }
 
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 1900) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
 
    public static void showToast(String str) {
        if (!show){
            return;
        }
        try {
            mToast.setText(str);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void showToast(int resId) {
        if (!show){
            return;
        }
        try {
            mToast.setText(resId);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
