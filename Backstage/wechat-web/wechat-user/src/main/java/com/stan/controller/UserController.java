package com.stan.controller;

import com.stan.entity.User;
import com.stan.entity.base.BusinessException;
import com.stan.entity.base.ResultEntity;
import com.stan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    /**
     *  用户注册
     *  1:用户名唯一性校验
     *  2:手机号码校验
     * @param user
     * @return
     */
    @RequestMapping("registerUser")
    public ResultEntity registerUser(User user) {

        System.out.println("UserController.registerUser");
        System.out.println(user);
        //1：用户名唯一性校验
        boolean uniquenessUserName = userService.UniquenessUserName(user.getUsername());
        if (uniquenessUserName) {
            return ResultEntity.error("用户名已经被占用");
        }

        //2:手机号码唯一性校验
        boolean uniquenessUserPhone = userService.uniquenessUserName(user.getPhone());
        if (uniquenessUserPhone) {
            return ResultEntity.error("手机号码已经被占用");
        }

        //添加到数据库中
        user.setCreateTime(new Date());
        userService.insert(user);
        return ResultEntity.success();
    }

    @RequestMapping("login")
    public ResultEntity login(User user){

        System.out.println(user);
        System.out.println("UserController.login");
        user = userService.getUserByName(user);
        System.out.println(user);
        //失败
        if (user == null){
            return ResultEntity.error("用户密码校验失败");
        }
        return  ResultEntity.success(user);
    }

}
