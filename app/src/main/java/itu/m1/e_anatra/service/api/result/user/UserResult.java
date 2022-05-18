package itu.m1.e_anatra.service.api.result.user;

import com.google.gson.annotations.SerializedName;

public class UserResult {
    @SerializedName("_id")
    private String id;

    @SerializedName("username")
    private String username;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("email")
    private String email;

    @SerializedName("login_password")
    private String loginPassword;

    public UserResult(String id, String username, String fullName, String email, String loginPassword) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.loginPassword = loginPassword;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}
