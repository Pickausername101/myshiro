package com.it.shiro.test;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * <P>
 *     自定义Realm配置
 * </P>
 * @Author 王文龙
 * @Date 2019-11-20 16:21
 */
public class MyRealm1 implements Realm {

    @Override
    public String getName() {
        return "MyRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持 UsernamePasswordToken 类型的 Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();//得到用户名
        String password = new String((char[]) token.getCredentials());//得到密码
        if (!"zhang1".equals(username)){
            throw new UnknownAccountException("用户名错误");//用户名错误抛出异常
        }
        if (!"1231".equals(password)){
            throw new IncorrectCredentialsException("密码错误");//密码错误抛出异常
        }
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
