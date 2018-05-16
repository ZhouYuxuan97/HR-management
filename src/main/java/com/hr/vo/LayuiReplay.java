package com.hr.vo;

import com.google.gson.Gson;

import java.util.List;

/**
 * 专门用于响应layui.tabel模块的vo
 */
public class LayuiReplay <T> {
    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public LayuiReplay(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static String toJson(boolean isSuccess,String msg,int count,List<? extends Object> data){
        int code = (isSuccess) ? 0 : 1;
        Gson gson = new Gson();
        LayuiReplay<? extends Object> replay = new LayuiReplay<>(code, msg, count, data);
        return gson.toJson(replay);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
