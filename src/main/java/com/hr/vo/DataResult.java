package com.hr.vo;

import com.google.gson.Gson;

public class DataResult <T> {
    private int status;
    private String message;
    private T data;

    public DataResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static String toJson(boolean isSuccess,String msg,Object data){
        int status = (isSuccess) ? 0 : 1;
        DataResult<Object> result = new DataResult<>(status, msg, data);
        return result.toJson();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
