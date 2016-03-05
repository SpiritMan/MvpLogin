package com.yolocc.mvplogin.model;

/**
 */
public interface IUser {

    String getName();
    String getPwd();

    int checkUserValidity(String name,String pwd);
}
