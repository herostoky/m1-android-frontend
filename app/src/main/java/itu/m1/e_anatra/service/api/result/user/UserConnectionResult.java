package itu.m1.e_anatra.service.api.result.user;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class UserConnectionResult {
    @SerializedName("_id")
    private String id;

    @SerializedName("user")
    private UserResult user;

    @SerializedName("token")
    private String token;

    @SerializedName("expiration_date")
    private Timestamp expirationDate;

    public UserConnectionResult() {    }
    public UserConnectionResult(String id, UserResult user, String token, Timestamp expirationDate) {
        this.id = id;
        this.user = user;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public UserResult getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(UserResult user) {
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isUserConnectionValid() {
        return ((boolean)(this.user != null && this.token != null /*&& (this.expirationDate == null || this.expirationDate.after(new Timestamp()))*/ ));
    }
}
