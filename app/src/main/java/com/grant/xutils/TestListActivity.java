package com.grant.xutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class TestListActivity extends AppCompatActivity implements View.OnLongClickListener,XutilsHttp.HttpRequesListener {

    private XutilsHttp xutilsHttp;
    private ListView mListView;
    private List<ListEntity> mlist;
    private TestListAdapter mTestListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);
        xutilsHttp = new XutilsHttp();//初始化请求框架 项目的时候需要做BaseActivity
        mlist = new ArrayList<>();
        mListView = (ListView) findViewById(R.id.test_list);
        initview();
        SendList();
    }

    private void initview() {

    }

    private void SendList() {
        xutilsHttp.setHttpRequesListener(this);
        RequestParams params = new RequestParams(NetworkRequest.LIST);
//        params.addBodyParameter();//添加传参
        xutilsHttp.sendRequest(params,this);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onFailure(String url, String errorContent, BaseJson baseJson) {

    }

    @Override
    public void onSuccess(String url, BaseJson baseJson) {
     if (url.equals(NetworkRequest.LIST)) {
         List<ListEntity> listEntities = JSON.parseArray(baseJson.getDisposeResult(),ListEntity.class);
         mlist.addAll(listEntities);
         mTestListAdapter = new TestListAdapter(this,mlist);
         mListView.setAdapter(mTestListAdapter);
         mTestListAdapter.notifyDataSetChanged();
     }
    }
}
