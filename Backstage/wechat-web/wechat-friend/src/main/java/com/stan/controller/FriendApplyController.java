package com.stan.controller;

import com.stan.entity.FriendApply;
import com.stan.entity.User;
import com.stan.entity.base.ResultEntity;
import com.stan.service.IFriendApplyService;
import com.stan.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/2 10:49
 * Content: 好友认证 好友状态 Controller
 */
@RestController
@RequestMapping("friendApply")
public class FriendApplyController {


    @Autowired
    private IFriendApplyService applyService;

    @Autowired
    private IUserService userService;

    /**
     * 发送添加好友认证信息
     * friendApply:认证信息实体类
     */
    @RequestMapping("addFriendApply")
    public ResultEntity addFriendApply(FriendApply friendApply,String username){


        //1:根据用户明查询 要添加的好友对象
        User user = userService.UserByUsername(username);
        if (user != null){

            //不能添加自己为好友的后天判断
            if (user !=null&& user.getId() == friendApply.getFid()){
                return ResultEntity.error("不能添加自己为好友");
            }

            //设置对方信息
            user.setPassword(null);
            friendApply.setTid(user.getId());
            friendApply.setCreateTime(new Date());
            //待同意
            friendApply.setStatus(1);
            System.out.println(friendApply);
            //添加到数据库中
            applyService.insert(friendApply);
            return ResultEntity.success("请求成为好友请求发送成功");
        }

        return  ResultEntity.error("不存在此用户，请稍后重试");
    }


    /**
     * 获取当前用户的好友请求 信息列表
     * @param uid
     * @return
     */
    @RequestMapping("getMyFriendApplyList")
    public ResultEntity getMyFriendApplyList(Integer uid){

        System.out.println(uid);
        //查询 tid 为 uid 的信息 , 且查出对方的信息
       List<FriendApply> friendApplies =  applyService.getMyFriendApplyList(uid);
        //循环遍历 查询 来之哪些 用户
        for (FriendApply friendApply:friendApplies){
            Integer fid = friendApply.getFid();
            User user = userService.getUserById(fid);
            friendApply.setFriend(user);
        }
        return ResultEntity.success(friendApplies);
    }


    //测试连接
    @RequestMapping("test")
    public String test(){
        return  "test";
    }

}
