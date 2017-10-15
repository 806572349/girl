package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 80657 on 2017/10/13.
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/test")
public class HelloController {
//    @Value("${cupSize}")
//    private  String cupsiez;
//    @Value("${age}")
//    private  String age;
    @Autowired
    private GirlProperties properties;

//    @RequestMapping(value = {"/hello"},method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public  String Say(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id){

        return "id"+id;
    }

}
