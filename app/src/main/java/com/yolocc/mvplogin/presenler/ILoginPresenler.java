package com.yolocc.mvplogin.presenler;

/**
 */
public interface ILoginPresenler {

    void clear();

    void doLogin(String name, String pwd);

    void setProgressBarVisibility(int visibility);
}
