package com.example.demo.service;

import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.repository.GirlRepository;
import com.example.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 80657 on 2017/10/15.
 */

/**
 * 事务回滚
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girl=new Girl();

    }

    public void getAge(Integer id)throws Exception{
      Girl girl=  girlRepository.findOne(id);
        Integer age =girl.getAge();
        if (age<20){
            //返回你在在上大学
            throw  new GirlException(ResultEnum.PRIMARY_SHCOOL);
        }else if(age>20&&age<25){
            //返回你在上研究
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
//        else {
//            throw  new GirlException(45,"反正现在的感情都暧昧");
//
//        }
    }

    public Girl findOne(Integer id){
        return  girlRepository.findOne(id);

    }
}
