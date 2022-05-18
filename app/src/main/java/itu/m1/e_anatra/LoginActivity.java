package itu.m1.e_anatra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import itu.m1.e_anatra.service.UserService;
import itu.m1.e_anatra.service.api.result.user.UserResult;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_login_btn)      Button   loginButton;
    @BindView(R.id.login_edittext_email) EditText loginEmailEditText;
    @BindView(R.id.login_edittext_pwd)   EditText loginPwdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_login_btn)
    public void login() {
        loginButton.setText("...");
        Log.d("email", String.valueOf(loginEmailEditText.getText()));
        Log.d("pwd", String.valueOf(loginPwdEditText.getText()));
        UserService userService = new UserService();
        boolean isLoggedIn = userService.userLogin(loginEmailEditText.getText().toString(), loginPwdEditText.getText().toString());
//        List<UserResult> test = userService.findAllUser();
        Log.d("result", "test");
        if(isLoggedIn)
            startMainActivity();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}