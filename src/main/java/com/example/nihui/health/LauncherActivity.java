package com.example.nihui.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/***
 * LauncherActivity，实现启动页面的优化
 *
 * 可优化
 *
 */

public class LauncherActivity extends Activity {

    private ImageView mImageView = null; // 准备获取到页面组件
    private float mAlpha = 1.0f;   //设置背景图片透明度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        //获取到页面组件
        mImageView = (ImageView) findViewById(R.id.launcher_background_image);

        //默认三秒之后启动主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GoIndexActivity();
            }
        },3000);
    }
    //定义函数用于页面跳转
    public void GoIndexActivity(){
        Intent intent = new Intent(LauncherActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
