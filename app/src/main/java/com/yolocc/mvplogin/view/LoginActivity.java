package com.yolocc.mvplogin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yolocc.mvplogin.R;
import com.yolocc.mvplogin.presenler.ILoginPresenler;
import com.yolocc.mvplogin.presenler.LoginPresenlerCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private EditText userName;
    private EditText pwd;
    private Button login, cancel;
    ILoginPresenler loginPresenler;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        login.setOnClickListener(this);
        cancel.setOnClickListener(this);

        loginPresenler = new LoginPresenlerCompl(this);
        loginPresenler.setProgressBarVisibility(View.INVISIBLE);
    }

    @Override
    public void onClearText() {
        userName.setText("");
        pwd.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenler.setProgressBarVisibility(View.INVISIBLE);
        login.setEnabled(true);
        cancel.setEnabled(true);
        if (result) {
            Toast.makeText(this, "login success", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "login fail , code = " + code, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginPresenler.setProgressBarVisibility(View.VISIBLE);
                login.setEnabled(false);
                cancel.setEnabled(false);
                loginPresenler.doLogin(userName.getText().toString(), pwd.getText().toString());
                break;
            case R.id.cancel:
                loginPresenler.clear();
                break;
        }
    }
}
