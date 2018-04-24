package com.grant.xutils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by grant on 2018/4/24 0024.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);//设置bug的输出
    }
}
