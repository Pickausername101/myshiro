package com.it.shiro.mapper;

import com.it.shiro.pojo.Sys_roles;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author 王文龙
 * @Date 2019-11-27 09:59
 */
public interface Sys_rolesMapper {

    //新增
    @Insert("insert into sys_roles(" +
            "role,\n" +
            "description,\n" +
            "available)" +
            "values(" +
            "#{role},\n" +
            "#{description},\n" +
            "#{available})")
    boolean insert(Sys_roles sys_roles);


    //删除
    @Delete("delete from sys_roles where id = #{id}")
    boolean delete(Integer id);
}
