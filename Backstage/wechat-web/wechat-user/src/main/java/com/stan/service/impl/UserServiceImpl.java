package com.stan.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stan.base.impl.BaseServiceimpl;
import com.stan.entity.User;
import com.stan.mapper.IUserMapper;
import com.stan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Stan
 * Date: 2019/11/29 20:41
 * Content:  用户服务
 */
@Service
public class UserServiceImpl extends BaseServiceimpl<User>  implements IUserService {

    @Autowired
    private IUserMapper userMapper;


    @Override
    public BaseMapper<User> baseMapper() {
        return userMapper;
    }
}
