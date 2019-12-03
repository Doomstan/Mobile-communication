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
 * Author: Stan
 * Date: 2019/11/29 19:33
 * Content:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {



    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String nickname;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "max_head")
    private String maxHead;

    @TableField(value = "min_head")
    private String minHead;

    private String pinyin;


}
