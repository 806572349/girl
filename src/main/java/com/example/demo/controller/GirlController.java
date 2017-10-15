package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import com.example.demo.untils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 80657 on 2017/10/15.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/",produces = "application/json;charset=utf-8")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> GetGirls(){
            return  girlRepository.findAll();

    }
    @PostMapping(value = "/girlss")
    public Result<Girl> GirlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result result=  new  Result<Girl>();
        if (bindingResult.hasErrors()){
            return null;
//            return ResultUtils.fail(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtils.success(girlRepository.save(girl));

    }
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
            return  girlRepository.findOne(id);
    }
    @PutMapping(value = "/girls/{id}")
    public  Girl girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("age") Integer age,
                            @RequestParam("cupSize") String cupSize
                            ){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    @GetMapping(value = "/age")
    public  List<Girl> FindGirlByAge(@RequestParam("age") Integer age){
      return   girlRepository.findByAge(age);

    }
    @GetMapping(value = "/girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
            girlService.getAge(id);
    }

}
