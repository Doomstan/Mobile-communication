package com.stan.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 好友认证实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_friend_apply")
public class FriendApply implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    //谁发的
    private Integer fid;
    //发给谁
    private Integer tid;
    //消息
    private String msg;
    //事件
    @TableField(value = "create_time")
    private Date createTime;
    //状态 1:等待  2：拒绝 3：同意
    private Integer status;

    //存放来着谁的用户对象
    @TableField(exist = false)
    private User friend;
}
