package com.example.chuwenbin.spiderapp.utils;

import android.util.Log;


/**
 * 打印日志工具
 * Created by liuzujun on 2016/9/20.
 */
public class LogUtil {

    // TAG 更新日志跳转到对应的代码位置  add by liuzujun  16.11.18
    static String className;
    static String methodName;
    static int lineNumber;
    static String TAG = "cwb";           //日志tag标识  可以修改
    static boolean DEBUGGABLE = true; //false/true
    private LogUtil() {

    }

    public static boolean isDebuggable() {
        return DEBUGGABLE;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append("]");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }

    public static void i(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.i(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.d(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.v(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.w(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }

    public static void wtf(String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(TAG, "(" + className + ":" + lineNumber + ")" + createLog(message));
    }


}
