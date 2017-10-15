package com.example.demo.domain;

/**
 * http请求返回的最外层对象
 * Created by 80657 on 2017/10/15.
 */
public class Result<T> {

    private  Integer code;

    private String msg;
    private  T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}