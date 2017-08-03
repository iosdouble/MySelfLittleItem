package com.example.nihui.health.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nihui on 2017/8/3.
 * Author nihui
 * Other 这个是一个基类，常用类，公共类
 * 我们实现的其他的布局都是继承这个类
 */

public abstract class BaseFragment extends Fragment {
    /*
     * 上下文
     */
    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**注意这里的页面的回调*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return initView();
    }

    //强制子类实现重写，实现子类特有的UI
    protected abstract View initView();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    //当子类需要初始化数据，或者联网请求数据，或者是展示数据的时候需要调用这个方法
    protected void initData(){

    }
}
