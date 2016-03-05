package com.yolocc.mvplogin.model;

import android.text.TextUtils;

/**
 */
public class UserModel implements IUser {

    String name;
    String pwd;

    public UserModel(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPwd() {
        return pwd;
    }

    @Override
    public int checkUserValidity(String name, String pwd) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd) || !TextUtils.equals(name, getName()) || !TextUtils.equals(pwd, getPwd())) {
            return -1;
        }
        return 0;
    }
}
