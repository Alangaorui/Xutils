package com.grant.xutils;

import android.app.ListActivity;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 使用注解的方式
 */

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.main_btn)
    private Button mMainBtn;
    @ViewInject(R.id.main_btn_long)
    private Button mMainBtnLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);//加入注解的方式添加初始化

    }

    //注解的点击事件
    @Event(type = View.OnClickListener.class,value = R.id.main_btn)
    private void httpsbtn(View view) {

        Intent intent = new Intent(MainActivity.this,ButtonAvtivity.class);
        startActivity(intent);
    }

    //长按事件
    @Event(type = View.OnLongClickListener.class,value = R.id.main_btn_long)
    private boolean OnLongClick(View view) {
        Toast.makeText(MainActivity.this,"长按事件的触发",Toast.LENGTH_SHORT).show();
        return true;
    }

    //多个点击事件
    @Event(value = {R.id.main_btn1, R.id.main_btn2, R.id.main_btn3})
    private void OnClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn1:
                Intent intent1 = new Intent(MainActivity.this,TestListActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_btn2:
                Intent intent2 = new Intent(MainActivity.this,ButtonAvtivity.class);
                startActivity(intent2);
                break;
            case R.id.main_btn3:
                Intent intent3 = new Intent(MainActivity.this,ButtonAvtivity.class);
                startActivity(intent3);
                break;
        }
    }
}
