package com.it.shiro.service;

import com.it.shiro.pojo.Sys_users;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @Author 王文龙
 * @Date 2019-11-27 15:48
 */
public interface Sys_usersService {


    /**
     * 创建账户
     * @param sys_users 用户表
     * @return true/false
     */
    boolean insert(Sys_users sys_users);

    /**
     * 修改密码
     * @param id 主键id
     * @param newPassword 密码
     * @return true/false
     */
    boolean changePassword(@Param("id")Integer id, @Param("newPassword") String newPassword);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return Sys_users
     */
    Sys_users findByUsername(String username);


    /**
     * 添加用户-角色关系
     * @param userId 用户id
     * @param roleIds 角色id
     * @return true/false
     */
    boolean correlationRoles(@Param("userId") Integer userId,@Param("roleIds") Integer roleIds);

    /**
     * 移除用户-角色关系
     * @param userId 用户id
     * @param roleIds 角色id
     * @return true/false
     */
    boolean uncorrelationRoles(@Param("userId") Integer userId,@Param("roleIds") Integer roleIds);

    /**
     * 根据用户名查找其角色
     * @param username 用户名
     * @return []
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username 用户名
     * @return []
     */
    Set<String> findPermissions(String username);
}
