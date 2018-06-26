package com.tiansu.test;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author wanggy
 * @date 2018/6/20
 * @desc 实体类User
 */
@Data
@AllArgsConstructor
public class User
{
    private String name;

    private Integer age;

    private Integer salary;

}
