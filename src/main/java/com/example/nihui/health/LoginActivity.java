package com.example.nihui.health;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nihui.health.bean.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by nihui on 2017/8/3.
 * Author nihui
 * Other
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mLoginBtn;
    private TextView mLognBtn;
    private TextView mForgetBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化页面
        initView();

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId("12c93f7649a8e07d04a0b455af77136e")
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);

        //设置监听事件
        setOnclick();

    }

    /**
     * 给下面的三个点击按钮添加事件
     */
    private void setOnclick() {
        mLoginBtn.setOnClickListener(this);
        mLognBtn.setOnClickListener(this);
        mForgetBtn.setOnClickListener(this);
    }

    /**
     * 初始化页面
     */

    private void initView() {
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLognBtn = (TextView) findViewById(R.id.logn_btn);
        mForgetBtn = (TextView) findViewById(R.id.only_show);
        mEditUsername = (EditText) findViewById(R.id.input_username);
        mEditPassword = (EditText) findViewById(R.id.input_password);
    }

    /**
     * 点击监听
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        onHideSoftInput(event);
        return super.onTouchEvent(event);
    }

    /**
     * 点击空白处,关闭输入法软键盘
     */
    public void onHideSoftInput(MotionEvent event)
    {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
            {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 监听事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        int viewid = view.getId();
        switch (viewid){
            case R.id.login_btn:  //登录按钮
                toast("你点击了登录按钮");
                addUser();
                break;
            case R.id.logn_btn: //用户注册
                toast("你点击了用户注册");
                break;
            case R.id.only_show: //忘记用户名
                toast("你点击了忘记姓名");
                break;
        }
    }

    public void addUser(){
        User user = new User();
        user.setUsername("lucky");
        user.setPassword("123");
        user.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }
    /**
     * 添加吐丝方法
     * @param str 吐丝字符串
     */
    public void toast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }
}
