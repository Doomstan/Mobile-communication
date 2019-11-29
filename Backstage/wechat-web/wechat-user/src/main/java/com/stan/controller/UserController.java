package com.stan.controller;

import com.stan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
