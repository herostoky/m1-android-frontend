package itu.m1.e_anatra.service.api.result;

import com.google.gson.annotations.SerializedName;

public class BaseResult<E> {
    public static String STATUS_OK = "OK";
    public static String STATUS_KO = "KO";

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private E data;

    @SerializedName("error")
    private String error;

    public BaseResult(String status, E data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccessful() {
        return ((boolean)(this.status == BaseResult.STATUS_OK));
    }

    public String getStatus() {
        return status;
    }

    public E getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
