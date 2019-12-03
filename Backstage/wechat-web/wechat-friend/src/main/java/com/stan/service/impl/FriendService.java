package com.stan.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stan.base.impl.BaseServiceimpl;
import com.stan.entity.Friend;
import com.stan.mapper.IFriendMapper;
import com.stan.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/3 10:09
 * Content:
 */
@Service
public class FriendService extends BaseServiceimpl<Friend> implements IFriendService {


    @Autowired
    private IFriendMapper friendMapper;

    @Override
    public BaseMapper<Friend> baseMapper() {
        return friendMapper;
    }


    /**
     * 添加好友
     * @param fid
     * @param tid
     */
    @Override
    public void addFriend(Integer fid, Integer tid) {
        friendMapper.addFriend(fid,tid);

    }


    /**
     * 查看好友
     * @param uid
     * @return
     */
    @Override
    public List<Friend> getFriendList(Integer uid) {

        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("uid",uid).eq("status",1);
        List list = friendMapper.selectList(wrapper);
        return list;
    }
}
