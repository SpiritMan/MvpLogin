package com.yolocc.mvplogin.presenler;

import android.os.Handler;
import android.os.Looper;

import com.yolocc.mvplogin.model.IUser;
import com.yolocc.mvplogin.model.UserModel;
import com.yolocc.mvplogin.view.ILoginView;

/**
 */
public class LoginPresenlerCompl implements ILoginPresenler {

    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenlerCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String pwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, pwd);
        isLoginSuccess = code == 0 ? true :false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    private void initUser() {
        user = new UserModel("longle", "longle");
    }
}
