package itu.m1.e_anatra.service;

import android.util.Log;

import java.util.List;

import itu.m1.e_anatra.LoginActivity;
import itu.m1.e_anatra.R;
import itu.m1.e_anatra.service.api.RetrofitClient;
import itu.m1.e_anatra.service.api.request.user.UserLoginRequest;
import itu.m1.e_anatra.service.api.result.BaseResult;
import itu.m1.e_anatra.service.api.result.user.UserConnectionResult;
import itu.m1.e_anatra.service.api.result.user.UserListResult;
import itu.m1.e_anatra.service.api.result.user.UserResult;
import itu.m1.e_anatra.service.session.UserConnectionSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {
    public UserService() {}

    public boolean userLogin(String username, String password, LoginActivity loginActivity) {
        UserLoginRequest userLoginRequest = new UserLoginRequest(username, password);
        Call<BaseResult<UserConnectionResult>> call = RetrofitClient.getInstance().getApi().userLogin(userLoginRequest);
        final UserConnectionResult userConnectionResult = new UserConnectionResult();
        Callback<BaseResult<UserConnectionResult>> callback = new Callback<BaseResult<UserConnectionResult>>() {
            @Override
            public void onResponse(Call<BaseResult<UserConnectionResult>> call, Response<BaseResult<UserConnectionResult>> response) {
                if (response.isSuccessful()) {
                    BaseResult<UserConnectionResult> result = response.body();
                    if (result.isSuccessful()) {
                        userConnectionResult.setToken(result.getData().getToken());
                        UserConnectionSession userConnectionSession = new UserConnectionSession(loginActivity.getSessionManagement());
                        userConnectionSession.setUserConnectionSession(userConnectionResult);
                        loginActivity.startMainActivity();
                        Log.d("users", result.toString());
                    }
                    else {
                        loginActivity.showToastError( loginActivity.getString(R.string.login_error));
                    }
                }
                else {
                    loginActivity.showToastError( loginActivity.getString(R.string.login_error));
                }
            }
            @Override
            public void onFailure(Call<BaseResult<UserConnectionResult>> call, Throwable t) {
                Log.d("error-api", t.getMessage());
                loginActivity.showToastError(t.getMessage());
            }
        };
        call.enqueue(callback);
        return userConnectionResult.isUserConnectionValid();
    }

    public List<UserResult> findAllUser() {
        Call<BaseResult<UserListResult>> call = RetrofitClient.getInstance().getApi().findAllUsers();
        call.enqueue(new Callback<BaseResult<UserListResult>>() {
            @Override
            public void onResponse(Call<BaseResult<UserListResult>> call, Response<BaseResult<UserListResult>> response) {
                BaseResult<UserListResult> result = response.body();
                Log.d("users", result.toString());
            }
            @Override
            public void onFailure(Call<BaseResult<UserListResult>> call, Throwable t) {
                Log.d("error-api", t.getMessage());
            }
        });
        return null;
    }
}
