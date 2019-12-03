package com.stan.controller;

import com.stan.entity.Friend;
import com.stan.entity.User;
import com.stan.entity.base.ResultEntity;
import com.stan.service.IFriendService;
import com.stan.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/3 10:08
 * Content:
 */
@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private IUserService userService;


    @Autowired
    private IFriendService friendService;


    /**
     * 获取好友列表
     *
     * @return
     */
    @RequestMapping("getFriendList")
    public ResultEntity getFriendList(Integer uid) {
        List<Friend> friendList = friendService.getFriendList(uid);
        System.out.println(friendList);
        //遍历查询出每一个用户的信息
        for (Friend friend : friendList){
            User user = userService.getUserById(friend.getFid());
            friend.setFriendObj(user);
        }
        System.out.println(friendList);
        return ResultEntity.success(friendList);
    }

}
