package com.it.shiro.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * <P>
 *     用户表
 * </P>
 * @Author 王文龙
 * @Date 2019-11-26 18:45
 */
@Data
@ToString
public class Sys_users {

    private Integer id;
    private String username;
    private String password;
    private String salt;

    public String getCredentialsSalt() {
        return username + salt;
    }
}
