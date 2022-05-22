package itu.m1.e_anatra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import itu.m1.e_anatra.service.UserService;
import itu.m1.e_anatra.service.api.result.user.UserResult;
import itu.m1.e_anatra.service.session.SessionManagement;
import itu.m1.e_anatra.service.session.UserConnectionSession;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_login_btn)      Button   loginButton;
    @BindView(R.id.login_edittext_email) EditText loginEmailEditText;
    @BindView(R.id.login_edittext_pwd)   EditText loginPwdEditText;

    // Session Management
    private SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if(sessionManagement == null)
            sessionManagement = new SessionManagement(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("start", "hfdjdfhjdhfjdfhjdf");
        UserConnectionSession userConnectionSession = new UserConnectionSession(sessionManagement);
        if(userConnectionSession.isUserConnected()) {
            this.startMainActivity();
        }
    }

    @OnClick(R.id.login_login_btn)
    public void login() {
        UserService userService = new UserService();
        String username = loginEmailEditText.getText().toString().trim();
        String password = loginPwdEditText.getText().toString();
        boolean isInputVerified = verifyInput(username, password);
        if(isInputVerified) {
            userService.userLogin(username, password, this);
        }
    }

    private boolean verifyInput(String username, String password) {
        boolean verified = true;
        if(TextUtils.isEmpty(password)) {
            verified = false;
            loginPwdEditText.setError( getString(R.string.input_required) );
            loginPwdEditText.requestFocus();
        }
        if(TextUtils.isEmpty(username)) {
            verified = false;
            loginEmailEditText.setError( getString(R.string.input_required) );
            loginEmailEditText.requestFocus();
        }
        if(verified && (password.length() < 6)) {
            verified = false;
            loginPwdEditText.setError( getString(R.string.input_password_length_required) );
            loginPwdEditText.requestFocus();
        }
        return verified;
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void showToastError(String message) {
        Toast.makeText(this, String.valueOf(message), Toast.LENGTH_LONG).show();
    }

    public SessionManagement getSessionManagement() {
        return sessionManagement;
    }
    public void setSessionManagement(SessionManagement sessionManagement) {
        this.sessionManagement = sessionManagement;
    }
}