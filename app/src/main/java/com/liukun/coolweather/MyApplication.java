package com.liukun.coolweather;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Author: liukun on 2020/4/28.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
