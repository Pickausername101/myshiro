package com.it.shiro.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * <P>
 *     用户角色关系
 * </P>
 * @Author 王文龙
 * @Date 2019-11-26 18:51
 */
@Data
@ToString
public class Sys_users_roles {
    private Integer userId;
    private Integer roleId;
}
