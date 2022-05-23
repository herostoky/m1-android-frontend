package itu.m1.e_anatra.service.session;

import android.content.Context;

import itu.m1.e_anatra.service.api.result.user.UserConnectionResult;

public class UserConnectionSession {
    public static String UC_TOKEN_SESSION_KEY    = "USER_SESSION_TOKEN";
    public static String UC_USERNAME_SESSION_KEY = "USER_SESSION_USERNAME";

    private SessionManagement session;

    public UserConnectionSession (SessionManagement sessionManagement) {
        this.session = sessionManagement;
    }

    public boolean isUserConnected() {
        String token    = this.session.getSession(UC_TOKEN_SESSION_KEY);
        String username = this.session.getSession(UC_USERNAME_SESSION_KEY);
        return (String.valueOf(token).compareTo("null") != 0) && (String.valueOf(username).compareTo("null") != 0);
    }

    public void setUserConnectionSession(UserConnectionResult userConnectionResult) {
        this.session.saveSession(UC_TOKEN_SESSION_KEY, String.valueOf(userConnectionResult.getToken().getToken()));
        this.session.saveSession(UC_USERNAME_SESSION_KEY, String.valueOf(userConnectionResult.getToken().getUser().getUsername()));
    }

    public void unsetUserConnectionSession() {
        this.session.destroySession(UC_TOKEN_SESSION_KEY);
        this.session.destroySession(UC_USERNAME_SESSION_KEY);
    }


}
