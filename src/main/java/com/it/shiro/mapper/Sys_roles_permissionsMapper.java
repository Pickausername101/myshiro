package com.it.shiro.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * <P>
 *     角色权限
 * </P>
 * @Author 王文龙
 * @Date 2019-11-27 10:05
 */
public interface Sys_roles_permissionsMapper {

    //添加 角色权限之间的关系
    @Insert("insert into sys_roles_permissions(" +
            "role_id,\n" +
            "permission_id)" +
            "values(" +
            "#{role_id},\n" +
            "#{permission_id})")
    boolean insert(Integer role_id,Integer permission_id);


    //移除角色权限之间的关系
    @Delete("delete from sys_roles_permissions where role_id = #{role_id} and permission_id = #{permission_id}")
    boolean delete(Integer role_id,Integer permission_id);
}
