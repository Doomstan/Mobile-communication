package com.stan.service;

import com.stan.base.IBaseService;
import com.stan.entity.FriendApply;

import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/2 17:01
 * Content:
 */
public interface IFriendApplyService extends IBaseService<FriendApply> {

    /**
     * 查看好友请求信息
     * @param uid
     * @return
     */
    List<FriendApply> getMyFriendApplyList(Integer uid);
}
