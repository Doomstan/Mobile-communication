package com.stan.service;

import com.stan.base.IBaseService;
import com.stan.entity.Friend;

import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/3 10:08
 * Content:
 */
public interface IFriendService extends IBaseService<Friend> {
    /**
     * 添加好友
     * @param fid
     * @param tid
     */
    void addFriend(Integer fid, Integer tid);

    /**
     * 查看好友
     * @param uid
     * @return
     */
    List<Friend> getFriendList(Integer uid);
}
