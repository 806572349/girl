package com.example.demo.enums;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by 80657 on 2017/10/15.
 */
public enum ResultEnum {
    UNKOWN_EEOR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SHCOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你还在上初中")

    ;
    private Integer code;
    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
}
