package com.grant.xutils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by grant on 2018/4/24 0024.
 * 封装Xutils的请求的接口
 * 看接口的定义是架构来设计
 */

public class XutilsHttp {

    private HttpRequesListener mHttpRequesListener;

    private Callback.Cancelable cancelable;

    private App app;

    private Context mContext;

    private Dialog mLoadingDialog;

    private static int mCount = 1;

    public XutilsHttp() {
        app = (App) x.app();
    }

    public interface HttpRequesListener {
        //成功与失败的时候返回结构体
        void onFailure(String url, String errorContent,BaseJson baseJson);

        void onSuccess(String url, BaseJson baseJson);
    }

    public void setHttpRequesListener(HttpRequesListener httpRequesListener) {
        this.mHttpRequesListener = httpRequesListener;
    }

    //请求网络

    public Dialog sendRequest(RequestParams params, Context context) {
        if (mHttpRequesListener == null) {
            throw new RuntimeException("无网络监听");
        }
        this.mContext = context;
        if (!NetUtils.isNetwork(context.getApplicationContext())) {
            mHttpRequesListener.onFailure(params.getUri(), "当前网络不可用\n请检查你的网络设置",null );
            return mLoadingDialog;
        }
       //设置请求时长
        params.setConnectTimeout(10000);
        // 发送post请求
        postRequest(params);
        return mLoadingDialog;
    }


    private void postRequest(final RequestParams params) {
        cancelable = x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                StringBuffer buffer = new StringBuffer();
                List<KeyValue> stringParams = params.getStringParams();
                for (int i = 0; i < stringParams.size(); i++) {
                    buffer.append(stringParams.get(i).key + "=" + stringParams.get(i).value + "  ");// 拼接需要的sign
                }

                if (mCount % 2 == 0) {

                } else {
                }
                mCount++;
                removeBOM(result);
                BaseJson jsonBase = JSONBaseUtil.getJSONBase(result);
                if (jsonBase == null) {
                    mHttpRequesListener.onFailure(params.getUri(), "返回数据异常",null);
                    return;
                }
                if (jsonBase.getInvoking().equals("success")) {
                    mHttpRequesListener.onSuccess(params.getUri(), jsonBase);
                } else {
                    mHttpRequesListener.onFailure(params.getUri(), jsonBase.getMessage(),null);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    //网络请求错误码
                    String errorCode = ((HttpException) ex).getErrorCode();
                    if (errorCode.equals("502")) {
                    }
                    mHttpRequesListener.onFailure(params.getUri(), "网络请求失败!",null);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                mHttpRequesListener.onFailure(params.getUri(), "Cancelled",null);
            }

            @Override
            public void onFinished() {

            }
        });
    }

    public static final String removeBOM(String data) {

        if (TextUtils.isEmpty(data)) {
            return data;
        }
        if (data.startsWith("\ufeff")) {
            return data.substring(1);
        } else {
            return data;
        }
    }
}
