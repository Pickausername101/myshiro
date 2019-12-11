package com.it.shiro.mapper;

import com.it.shiro.pojo.Sys_permissions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author 王文龙
 * @Date 2019-11-26 19:07
 */
public interface Sys_permissionMapper {



    //新增
    @Insert("insert into sys_permissions(" +
            "permission,\n" +
            "description,\n" +
            "available)" +
            "values(" +
            "#{permission},\n" +
            "#{description},\n" +
            "#{available})")
    boolean insert(Sys_permissions sys_permissions);


    //删除
    @Delete("delete from sys_permissions where id = #{id}")
    boolean delete(Integer id);

}
