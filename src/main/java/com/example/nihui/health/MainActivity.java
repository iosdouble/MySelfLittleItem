package com.example.nihui.health;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.nihui.health.base.BaseFragment;
import com.example.nihui.health.fragment.FriendFragment;
import com.example.nihui.health.fragment.HealthFragment;
import com.example.nihui.health.fragment.IndexFragment;
import com.example.nihui.health.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;


/***
 *  1.先把整个应用的框架都搭建起来
 *  2.设计出登录页面
 *  3.实现页面的跳转功能
 */
public class MainActivity extends FragmentActivity {

    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragmentList;

    /*
     * 选中的Fragment对应的位置
     */
    private  int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View

        initView();
        //初始化Fragment
        initFragment();

        //设置RadioGroup事件监听
        setListener();

    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中
        mRg_main.check(R.id.index_button_id);
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.index_button_id: //首页
                        position = 0;
                        break;
                    case R.id.health_button_id://健康
                        position = 1;
                        break;
                    case R.id.friend_button_id:// 朋友
                        position = 2;
                        break;
                    case R.id.me_button_id: //我自己
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }


            //根据位置得到页面
               BaseFragment fragment = getFragment();
            //替换
               switchFragment(fragment);
            }
        }

    private void switchFragment(BaseFragment fragment) {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //替换
        transaction.replace(R.id.fl_content,fragment);
        //提交事务
        transaction.commit();

    }

    //根据位置得到Fragment
    private BaseFragment getFragment() {
        BaseFragment fragment =  mBaseFragmentList.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragmentList = new ArrayList<>();
        mBaseFragmentList.add(new IndexFragment());//主页
        mBaseFragmentList.add(new HealthFragment());//健康
        mBaseFragmentList.add(new FriendFragment());//朋友
        mBaseFragmentList.add(new MeFragment()) ; //我自己

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);

    }

}
