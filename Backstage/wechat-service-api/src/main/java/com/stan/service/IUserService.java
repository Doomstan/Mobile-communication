package com.stan.service;

import com.stan.base.IBaseService;
import com.stan.entity.User;

/**
 * Author: Stan
 * Date: 2019/11/29 20:40
 * Content:
 */
public interface IUserService extends IBaseService<User> {
    /**
     * 唯一性校验
     * 用户名
     * @param username
     * @return true : 存在  false : 不存在
     */
    boolean UniquenessUserName(String username);

    /**
     * 手机号码唯一性校验
     * @param phone
     * @return true: 存在  false:不存在
     */
    boolean uniquenessUserName(String phone);

    /**
     * 登录校验
     * @param user
     * @return
     */
    User getUserByName(User user);
}
