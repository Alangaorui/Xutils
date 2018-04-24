package com.grant.xutils;

import java.io.Serializable;

/**
 * Created by grant on 2018/4/24 0024.
 * 根据服务端的接口的模式来请求定义接口的BaseJson
 */

public class BaseJson implements Serializable{

    private String message;

    private String invoking;

    private String alertCode;

    private String disposeResult;

    public BaseJson() {

    }

    public BaseJson(String message, String invoking, String alertCode, String disposeResult) {
        this.message = message;
        this.invoking = invoking;
        this.alertCode = alertCode;
        this.disposeResult = disposeResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvoking() {
        return invoking;
    }

    public void setInvoking(String invoking) {
        this.invoking = invoking;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }

    public String getDisposeResult() {
        return disposeResult;
    }

    public void setDisposeResult(String disposeResult) {
        this.disposeResult = disposeResult;
    }

    @Override
    public String toString() {
        return "BaseJson{" +
                "message='" + message + '\'' +
                ", invoking='" + invoking + '\'' +
                ", alertCode='" + alertCode + '\'' +
                ", disposeResult='" + disposeResult + '\'' +
                '}';
    }
}
