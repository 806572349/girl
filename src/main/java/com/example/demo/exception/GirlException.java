package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * Created by 80657 on 2017/10/15.
 */
//spring中只对RuntimeException进行事务回滚，Exception好像不进行；
public class GirlException  extends RuntimeException{

    private  Integer code;
    private  ResultEnum resultEnum;
    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.resultEnum=resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
