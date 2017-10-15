package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 80657 on 2017/10/15.
 */

/**
 * AOP日志处理
 */
@Aspect
@Component
public class HttpAspnct {
//    @Before("execution(public * com.example.demo.controller.GirlController.GetGirls(..))")//方法级别的拦截
//    @Before("execution(public * com.example.demo.controller.GirlController.*(..))")//控制器级别的拦截
//    public void log(){
//        System.out.println("我拦截了");
//    }
//    @After("execution(public * com.example.demo.controller.GirlController.*(..))")
//    public  void afterlog(){
//        System.out.println("女孩被魔龙劫走了");
//
//    }

    private  final  static Logger logger= LoggerFactory.getLogger(HttpAspnct.class);
    /**
     *
     */
    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log(){
    }
    @Before("log()")
    public  void BeforeLoG(JoinPoint joinPoint){

      ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      HttpServletRequest request= attributes.getRequest();


      //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getDeclaringType());

        //参数
        logger.info("args={}",joinPoint.getArgs());

    }
    @After("log()")
    public void Afterlog(){
        logger.info("222222222222");
    }
    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfter(Object obj){
        logger.info("response={}",obj.toString());

    }


}
