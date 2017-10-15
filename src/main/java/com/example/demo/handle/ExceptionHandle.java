package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.untils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 80657 on 2017/10/15.
 */
@ControllerAdvice
public class ExceptionHandle {
private static  Logger lg= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception ex){
    if(ex instanceof GirlException){
        GirlException girlException=(GirlException)ex;
        return ResultUtils.fail(girlException.getResultEnum());
    }else {
        lg.error("系统异常{}",ex.getMessage());
        return ResultUtils.fail(ResultEnum.UNKOWN_EEOR);

    }


    }
}
