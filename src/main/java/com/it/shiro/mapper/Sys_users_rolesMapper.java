package com.it.shiro.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @Author 王文龙
 * @Date 2019-11-27 11:14
 */
public interface Sys_users_rolesMapper {

    //添加用户-角色关系
    @Insert("insert into sys_users_roles(" +
            "user_id,\n" +
            "role_id)" +
            "values(" +
            "#{userId},\n" +
            "#{roleIds})")
    boolean correlationRoles(@Param("userId") Integer userId,@Param("roleIds") Integer roleIds);

    // 移除用户-角色关系
    @Delete("delete from sys_users_roles where user_id = #{userId} and role_id = #{roleIds}")
    boolean uncorrelationRoles(@Param("userId") Integer userId,@Param("roleIds") Integer roleIds);

    // 根据用户名查找其角色
    @Select("select ro.role from sys_users_roles ur\n" +
            "left join sys_users us on ur.user_id = us.id\n" +
            "left join sys_roles ro on ur.role_id = ro.id\n" +
            "where us.username like CONCAT('%',#{username},'%')")
    Set<String> findRoles(String username);

    //根据用户名查找其权限
    @Select("select p.permission from sys_users_roles ur\n" +
            "left join sys_users us on ur.user_id = us.id\n" +
            "left join sys_roles ro on ur.role_id = ro.id\n" +
            "left join sys_roles_permissions rp on ur.role_id = rp.permission_id\n" +
            "left join sys_permissions p on rp.permission_id = p.id"+
            "where us.username like CONCAT('%',#{username},'%')")
    Set<String> findPermissions(String username);
}
