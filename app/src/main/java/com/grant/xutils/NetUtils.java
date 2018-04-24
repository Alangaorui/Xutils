package com.grant.xutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by grant on 2018/4/24 0024.
 */

public class NetUtils {

    /**
     * 没有网络
     */
    public static final int NETWORK_NONE = 0;
    /**
     * WIFI状态下
     */
    public static final int NETWORK_WIFI = 1;
    /**
     * 移动网络
     */
    public static final int NETWORK_MOBILE = 2;

    /**
     * 判断是否有网络连接
     */
    public static boolean isNetwork(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断WIFI是否打开
     *
     * @param context
     * @return
     */
    public static boolean isWifiEnabled(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

    /**
     * 判断3G网络是否打开
     *
     * @param context
     * @return
     */
    public static boolean is3Grd(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

    /**
     * 判断网络类型
     *
     * @param context
     * @return
     */
    public static int getNetworkState(Context context) {
        if (isWifiEnabled(context)) {
            return NETWORK_WIFI;
        } else if (is3Grd(context)) {
            return NETWORK_MOBILE;
        }
        return NETWORK_NONE;
    }

}
