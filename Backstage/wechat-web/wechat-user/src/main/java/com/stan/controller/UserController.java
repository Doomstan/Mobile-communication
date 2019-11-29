package com.stan.controller;

import com.stan.entity.User;
import com.stan.entity.base.BusinessException;
import com.stan.entity.base.ResultEntity;
import com.stan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Author: Stan
 * Date: 2019/11/29 20:36
 * Content:
 */


@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private IUserService userService;


    //测试
    @RequestMapping("test")
    public String test() {
        System.out.println("UserController.test");
        return "test";
    }


    //全局异常测试
    @RequestMapping("exception")
    public ResultEntity exceptionTest() {
        int i = new Random().nextInt(2);
        if (i == 0) {
            return ResultEntity.success();
        } else {
            throw new BusinessException();
        }
    }



    //用户注册
    @RequestMapping("registerUser")
    public ResultEntity registerUser(User user){

        //唯一性校验



        return null;
    }


}
