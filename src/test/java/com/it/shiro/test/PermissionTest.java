package com.it.shiro.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author 王文龙
 * @Date 2019-11-25 11:53
 */
public class PermissionTest extends BaseTest{

    @Test
    public void tesIsPermitted(){
        login("classpath:shiro-permission.ini.properties","zhang","123");
        //判断拥有权限 user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //判断拥有权限:user:update and user:delete
        Assert.assertTrue(subject().isPermittedAll("user:update","user:delete"));
        //判断没有权限
        Assert.assertFalse(subject().isPermitted("user:view"));
    }

    /**
     * 这两个方法相比较，当没有权限的时候，下面的方法会抛出异常，而上面的不会
     */
    @Test
    public void testCheckPermission(){
        login("classpath:shiro-permission.ini.properties","zhang","123");
        //断言拥有权限
        subject().checkPermission("user:create");
        //断言拥有权限
        subject().checkPermissions("user:delete","user:update");
        //断言拥有权
        subject().checkPermissions("user:view");
    }
}
