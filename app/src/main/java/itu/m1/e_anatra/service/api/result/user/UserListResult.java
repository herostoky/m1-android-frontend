package itu.m1.e_anatra.service.api.result.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserListResult {
    @SerializedName("users")
    private List<UserResult> users;

    public UserListResult(List<UserResult> users) {
        this.users = users;
    }

    public List<UserResult> getUsers() {
        return users;
    }
}
