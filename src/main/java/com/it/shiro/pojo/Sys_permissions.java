package com.it.shiro.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 王文龙
 * @Date 2019-11-26 18:46
 */
@Data
@ToString
public class Sys_permissions {

    private Integer id;
    private String permission; //权限标识 程序中判断使用,如"user:create"
    private String description; //权限描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户
}
