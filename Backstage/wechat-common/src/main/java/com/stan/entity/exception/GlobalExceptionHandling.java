package com.stan.entity.exception;

import com.stan.entity.base.BusinessException;
import com.stan.entity.base.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Stan
 * Date: 2019/11/29 19:45
 * Content:  全局异常处理
 */
@ControllerAdvice  //AOP增强类
public class GlobalExceptionHandling {


    /**
     * 系统异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class) //捕捉指定异常 交由被标记的方法处理
    @ResponseBody
    public ResultEntity systemEx(Exception e){
        System.out.println("系统异常"+e.getMessage());
        return ResultEntity.error(e.getMessage());
    }


    /**
     * 业务异常处理 ： 业务自定义抛出异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultEntity systemBusiness(BusinessException e){
        System.out.println("业务异常"+e.getMsg());
        return ResultEntity.error(e.getMsg());
    }




}
