package com.stan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stan.entity.Friend;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Stan
 * Date: 2019/12/3 10:10
 * Content:
 */
public interface IFriendMapper extends BaseMapper<Friend> {
    void addFriend(@Param("fid") Integer fid, @Param("tid") Integer tid);
}
