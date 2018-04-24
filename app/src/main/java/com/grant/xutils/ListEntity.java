package com.grant.xutils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by grant on 2018/4/24 0024.
 */

public class ListEntity implements Serializable {

    @SerializedName("bankCode")
    private String bankCode;
    @SerializedName("bankContent")
    private String bankContent;
    @SerializedName("bankName")
    private String bankName;
    @SerializedName("bankLogo")
    private String bankLogo;

    public ListEntity() {}

    public ListEntity(String bankCode, String bankContent, String bankName, String bankLogo) {
        this.bankCode = bankCode;
        this.bankContent = bankContent;
        this.bankName = bankName;
        this.bankLogo = bankLogo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankContent() {
        return bankContent;
    }

    public void setBankContent(String bankContent) {
        this.bankContent = bankContent;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String bankLogo) {
        this.bankLogo = bankLogo;
    }

    @Override
    public String toString() {
        return "ListEntity{" +
                "bankCode='" + bankCode + '\'' +
                ", bankContent='" + bankContent + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankLogo='" + bankLogo + '\'' +
                '}';
    }
}
