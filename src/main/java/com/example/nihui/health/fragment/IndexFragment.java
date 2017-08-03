package com.example.nihui.health.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.nihui.health.base.BaseFragment;

/**
 * Created by nihui on 2017/8/3.
 * Author nihui
 * Other 主页的Fragment
 */

public class IndexFragment extends BaseFragment {

    private TextView textView;
    private static final  String TAG = IndexFragment.class.getCanonicalName();

    @Override
    protected View initView() {

        Log.e(TAG,"常用框架的Fragment被创建");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    //重写父类方法
    protected void initData(){
        super.initData();
        Log.e(TAG,"数据被加载");
        textView.setText("这个是一个字符串");
    }
}
