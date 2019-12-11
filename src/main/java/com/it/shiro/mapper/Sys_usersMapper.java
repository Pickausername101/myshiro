package com.it.shiro.mapper;

import com.it.shiro.pojo.Sys_users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author 王文龙
 * @Date 2019-11-27 10:25
 */
public interface Sys_usersMapper {

    //创建账户
    @Insert("insert into sys_users(" +
            "username,\n" +
            "password,\n" +
            "salt,\n" +
            "locked)" +
            "values(" +
            "#{username},\n" +
            "#{password},\n" +
            "#{salt},\n" +
            "#{locked})")
    boolean insert(Sys_users sys_users);

    //修改密码
    @Update("update sys_users set " +
            "username =#{username},\n" +
            "password = #{newPassword},\n" +
            "salt=#{salt},\n" +
            "locked=#{locked}\n" +
            "where id = #{id}")
    boolean update(Sys_users sys_users);


    // 根据用户名查找用户
    @Select("select * from sys_users where username like CONCAT('%',#{username},'%')")
    Sys_users findByUsername(String username);


    //根据id查询
    @Select("select * from sys_users where id = #{userId}")
    Sys_users findById(Integer userId);

}
