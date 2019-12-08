package com.stan.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Stan
 * Date: 2019/11/29 19:52
 * Content:  自定义异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    //错误码
    private String code ;
    //错误信息
    private String msg ;


}

