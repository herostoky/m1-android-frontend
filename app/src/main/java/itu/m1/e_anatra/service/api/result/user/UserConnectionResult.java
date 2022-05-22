package itu.m1.e_anatra.service.api.result.user;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class UserConnectionResult {
    @SerializedName("token")
    private UserTokenResult token;

    public UserConnectionResult() {   }

    public UserConnectionResult(UserTokenResult token) {
        this.token = token;
    }

    public UserTokenResult getToken() {
        return token;
    }

    public void setToken(UserTokenResult token) {
        this.token = token;
    }

    public boolean isUserConnectionValid() {
        boolean result = this.token != null;
        if(result)
            result &= (this.token.getUser() != null && this.token.getToken() != null /*&& (this.expirationDate == null || this.expirationDate.after(new Timestamp()))*/ );
        return result;
    }
}
