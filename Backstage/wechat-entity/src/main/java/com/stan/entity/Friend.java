package com.stan.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Stan
 * Date: 2019/12/3 9:57
 * Content:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_friend")
public class Friend {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer fid;

    private Integer status;

    private String remark;

    @TableField(exist = false)
    private User friendObj; // 好友对象


}
