package com.example.demo.untils;

import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;

/**
 * Created by 80657 on 2017/10/15.
 */
public class ResultUtils {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);

        return  result;
    }

    public  static  Result success(){
        return  success(null);
    }

    public static Result fail(ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return  result;

    }
}
