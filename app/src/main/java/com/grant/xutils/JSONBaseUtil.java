package com.grant.xutils;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by grant on 2018/4/24 0024.
 */

public class JSONBaseUtil {

    public static BaseJson getJSONBase(String jsonString) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonObject == null) {
            return null;
        }

        String message = null;
        String invoking = null;
        String alertCode = null;
        String disposeResult = null;
        try {
            disposeResult = jsonObject.getString("disposeResult");

            String invokingResult = jsonObject.getString("invokingResult");
            JSONObject jsonObject2 = new JSONObject(invokingResult);
            message = jsonObject2.getString("message");
            invoking = jsonObject2.getString("invoking");
            alertCode = jsonObject2.getString("alertCode");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        BaseJson baseJson = new BaseJson();
        baseJson.setMessage(message);
        baseJson.setInvoking(invoking);
        baseJson.setAlertCode(alertCode);
        baseJson.setDisposeResult(disposeResult);

        return baseJson;
    }
}
