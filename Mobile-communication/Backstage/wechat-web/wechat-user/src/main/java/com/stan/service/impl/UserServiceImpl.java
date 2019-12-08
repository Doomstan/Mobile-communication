package com.stan.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
public class UserServiceImpl extends BaseServiceimpl<User> implements IUserService {

    @Autowired
    private IUserMapper userMapper;


    @Override
    public BaseMapper<User> baseMapper() {
        return userMapper;
    }

    @Override
    public boolean UniquenessUserName(String username) {

        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("username", username);
        Integer integer = userMapper.selectCount(wrapper);
        return integer != 0 ? true : false;
    }


    @Override
    public boolean uniquenessUserName(String phone) {

        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("phone", phone);
        Integer integer = userMapper.selectCount(wrapper);
        return integer != 0 ? true : false;
    }


    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User getUserByNameAndPassword(User user) {
        user = userMapper.selectOne(user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {

        User user = new User();
        user.setUsername(username);
        user = userMapper.selectOne(user);
        if (user != null) {
            user.setPassword(null);
        }
        return user;
    }
}
