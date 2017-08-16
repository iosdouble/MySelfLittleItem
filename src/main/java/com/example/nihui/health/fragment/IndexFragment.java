package com.example.nihui.health.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nihui.health.R;
import com.example.nihui.health.base.BaseFragment;

/**
 * Created by nihui on 2017/8/3.
 * Author nihui
 * Other 主页的Fragment
 */

public class IndexFragment extends BaseFragment {

    private static final  String TAG = IndexFragment.class.getCanonicalName();

    private ListView listView;

    String[] objectArray={"健康建议","健康建议","健康建议","健康建议","健康建议","健康建议"};
    @Override
    protected View initView() {

        Log.e(TAG,"常用框架的Fragment被创建");
        View view = View.inflate(mContext, R.layout.fragment_index,null);
        listView = (ListView) view.findViewById(R.id.show_item);
        return view;
    }

    //重写父类方法
    protected void initData(){
        super.initData();
        Log.e(TAG,"数据被加载");
        listView.setAdapter(new ArrayAdapter(mContext,R.layout.item,objectArray));

    }

}
