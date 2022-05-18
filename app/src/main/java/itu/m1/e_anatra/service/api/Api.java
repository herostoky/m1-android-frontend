package itu.m1.e_anatra.service.api;

import itu.m1.e_anatra.service.api.request.user.UserLoginRequest;
import itu.m1.e_anatra.service.api.result.BaseResult;
import itu.m1.e_anatra.service.api.result.user.UserConnectionResult;
import itu.m1.e_anatra.service.api.result.user.UserListResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://e-bosy.herokuapp.com/";

    @GET("user/find-all")
    Call<BaseResult<UserListResult>> findAllUsers();
    @POST("user/login")
    Call<BaseResult<UserConnectionResult>> userLogin(@Body UserLoginRequest userLoginRequest);

}
