package com.it.shiro.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author 王文龙
 * @Date 2019-11-22 15:57
 */
public class RoleTest extends BaseTest{

    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini.properties","zhang","123");
        //判断拥有角色：role1
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色 role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
        //判断拥有角色 role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true,result[0]);
        Assert.assertEquals(true,result[1]);
        Assert.assertEquals(true,result[2]);
    }

    @Test
    public void testCheckRole(){
        login("classpath:shiro-role.ini.properties","zhang","123");
        //断言 拥有角色
        subject().checkRole("role1");
        //断言拥有角色  role1 and role3 失败抛出异常
        subject().checkRoles("role1","role3");
    }

}
