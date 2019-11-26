package com.it.shiro.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * <P>
 *     权限表
 * </P>
 * @Author 王文龙
 * @Date 2019-11-26 18:37
 */
@Data
@ToString
public class Sys_roles {

    private Integer id;//权限 id
    private String role;//角色标识 程序中判断使用,如"admin"
    private String description;//角色描述,UI界面显示使用
    private Boolean available=Boolean.FALSE;//是否可用,如果不可用将不会添加给用户
}
