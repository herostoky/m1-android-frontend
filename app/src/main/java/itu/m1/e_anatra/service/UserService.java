package itu.m1.e_anatra.service;

import android.util.Log;

import java.util.List;

import itu.m1.e_anatra.service.api.RetrofitClient;
import itu.m1.e_anatra.service.api.request.user.UserLoginRequest;
import itu.m1.e_anatra.service.api.result.BaseResult;
import itu.m1.e_anatra.service.api.result.user.UserConnectionResult;
import itu.m1.e_anatra.service.api.result.user.UserListResult;
import itu.m1.e_anatra.service.api.result.user.UserResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {
    public UserService() {}

    public boolean userLogin(String username, String password) {
        UserLoginRequest userLoginRequest = new UserLoginRequest(username, password);
        Call<BaseResult<UserConnectionResult>> call = RetrofitClient.getInstance().getApi().userLogin(userLoginRequest);
        final UserConnectionResult userConnectionResult = new UserConnectionResult();
        call.enqueue(new Callback<BaseResult<UserConnectionResult>>() {
            @Override
            public void onResponse(Call<BaseResult<UserConnectionResult>> call, Response<BaseResult<UserConnectionResult>> response) {
                if(response.isSuccessful()) {
                    BaseResult<UserConnectionResult> result = response.body();
                    if(result.isSuccessful()) {
                        userConnectionResult.setId(result.getData().getId());
                        userConnectionResult.setUser(result.getData().getUser());
                        userConnectionResult.setToken(result.getData().getToken());
                        userConnectionResult.setExpirationDate(result.getData().getExpirationDate());
                        // OK BE
                        //TODO: Sauvegarde TOKEN En local storage
                    }
                    Log.d("users", result.toString());
                }
            }
            @Override
            public void onFailure(Call<BaseResult<UserConnectionResult>> call, Throwable t) {
                Log.d("error-api", t.getMessage());
            }
        });
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
