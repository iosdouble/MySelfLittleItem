package com.example.nihui.health;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nihui on 2017/8/3.
 * Author nihui
 * Other
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private Button mLoginBtn;
    private TextView mLognBtn;
    private TextView mForgetBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLognBtn = (TextView) findViewById(R.id.logn_btn);
        mForgetBtn = (TextView) findViewById(R.id.only_show);

        mLoginBtn.setOnClickListener(this);
        mLognBtn.setOnClickListener(this);
        mForgetBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewid = view.getId();
        switch (viewid){
            case R.id.login_btn:  //登录按钮
                toast("你点击了登录按钮");
                break;
            case R.id.logn_btn: //用户注册
                toast("你点击了用户注册");
                break;
            case R.id.only_show: //忘记用户名
                toast("你点击了忘记姓名");
                break;
        }
    }
    public void toast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }
}
