package com.it.shiro.test;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Author 王文龙
 * @Date 2019-11-21 09:59
 */
public class MyRealm2 implements Realm {


    @Override
    public String getName() {
        return "myrealm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;//仅支持usernamePasswordToken类型的Token
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();//得到用户名
        String password = new String((char[]) token.getCredentials());//得到密码
        if (!"wang".equals(username)){
            throw new UnknownAccountException();//用户名错误抛出的异常
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();//密码错误抛出的异常
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
