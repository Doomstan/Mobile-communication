package com.stan.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Stan
 * Date: 2019/11/29 19:43
 * Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {

    private static final String SUCCESS = "ok";
    private static final String ERROR = "error";

    private static  final String NO_MSG = null;

    private String code; // 提示信息码

    private String msg; // 提示信息

    private Object data;

    /**
     * 成功没有数据
     * @return
     */
    public static ResultEntity success(){
        return new ResultEntity(SUCCESS,NO_MSG,null);
    }


    /**
     * 成功有数据
     * @param data
     * @return
     */
    public static ResultEntity success(Object data){
        return new ResultEntity(SUCCESS,NO_MSG,data);
    }

    /**
     * 错误有信息
     * @param msg
     * @return
     */
    public static ResultEntity error(String msg){
        return new ResultEntity(ERROR,msg,null);
    }



}
