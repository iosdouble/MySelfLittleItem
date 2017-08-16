package com.example.nihui.health.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by nihui on 2017/8/16.
 * Author nihui
 * Other
 */

public class User extends BmobObject {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
