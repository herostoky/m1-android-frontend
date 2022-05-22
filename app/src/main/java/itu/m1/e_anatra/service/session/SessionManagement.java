package itu.m1.e_anatra.service.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "SESSION";

    public SessionManagement (Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(String key, String value) {
        editor.putString(key, value).commit();
    }

    public String getSession(String key){
        return sharedPreferences.getString(key, "null");
    }

    public void destroySession(String key) {
        editor.remove(key).commit();
    }
}
