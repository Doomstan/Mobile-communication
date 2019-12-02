package com.stan.service.api;

import com.stan.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: Stan
 * Date: 2019/12/2 10:53
 * Content: 调用User微服务接口
 */
@FeignClient("USER-WEB")
public interface IUserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @RequestMapping("/user/findUserByUsername")
    public User UserByUsername(@RequestParam("username")String username);


    /**
     * 根据用户id 查询出用户信息
     */
    @RequestMapping("/user/findGetUsrById")
    public User getUserById(@RequestParam("uid") Integer uid);

}
