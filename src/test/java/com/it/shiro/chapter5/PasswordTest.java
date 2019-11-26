package com.it.shiro.chapter5;

import com.it.shiro.test.BaseTest;
import org.junit.Test;

/**
 * @Author 王文龙
 * @Date 2019-11-26 14:06
 */
public class PasswordTest extends BaseTest {

    @Test
    public void testPasswordServiceWithMyRealm(){
        login("classpath:shiro-passwordservice.ini.properties","wu","123");
    }

    @Test
    public void testHashedCredentialsMatcherWithMyRealm2() {
        //使用testGeneratePassword生成的散列密码
        login("classpath:shiro-hashedCredentialsMatcher.ini.properties", "liu", "123");
    }
}
