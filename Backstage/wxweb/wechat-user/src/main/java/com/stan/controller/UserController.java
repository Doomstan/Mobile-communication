package com.stan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Stan
 * Date: 2019/11/28 20:34
 * Content:
 */
@RestController
@RequestMapping("user")
public class UserController {



    @RequestMapping("test")
    public String test(){
        return "test";
    }


}
