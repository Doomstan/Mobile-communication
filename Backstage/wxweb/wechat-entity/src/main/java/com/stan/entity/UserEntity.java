package com.stan.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author: Stan
 * Date: 2019/11/28 20:47
 * Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class UserEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String  username;

    private String password ;

    private String phone ;

    @TableField("max_head")
    private String maxHead ;

    @TableField("min_head")
    private String minHead ;

    @TableField("create_time")
    private Date createTime;

    @TableField("nickname")
    private String  nickName;


}
