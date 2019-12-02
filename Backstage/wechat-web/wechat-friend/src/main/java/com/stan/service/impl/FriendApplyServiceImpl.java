package com.stan.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stan.base.impl.BaseServiceimpl;
import com.stan.entity.FriendApply;
import com.stan.mapper.IFriendApplyMapper;
import com.stan.service.IFriendApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Stan
 * Date: 2019/12/2 17:15
 * Content:
 */
@Service
public class FriendApplyServiceImpl extends BaseServiceimpl<FriendApply> implements IFriendApplyService {

    @Autowired
    private IFriendApplyMapper applyMapper;

    @Override
    public BaseMapper<FriendApply> baseMapper() {
        return applyMapper;
    }


    @Override
    public List<FriendApply> getMyFriendApplyList(Integer uid) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("tid", uid);
        return applyMapper.selectList(wrapper);
    }
}
