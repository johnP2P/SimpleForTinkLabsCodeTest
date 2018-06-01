package com.hqm.simplefortinklabscodetest.common;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by john on 2017/9/14.
 * log 工具类
 */

public class PaLog {
    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化

    private static final String TAG = PaLog.class.getSimpleName();

    private PaLog() {
          /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // 下面五个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug && !TextUtils.isEmpty(msg))
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug && !TextUtils.isEmpty(msg))
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(tag, msg);
    }
}
