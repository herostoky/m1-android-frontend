package itu.m1.e_anatra.service.api.request.user;

import com.google.gson.annotations.SerializedName;

public class UserLoginRequest {
    @SerializedName("username")
    private String username;

    @SerializedName("login_password")
    private String loginPassword;

    public UserLoginRequest(String username, String loginPassword) {
        this.username = username;
        this.loginPassword = loginPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}
