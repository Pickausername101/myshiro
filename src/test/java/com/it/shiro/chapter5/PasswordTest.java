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
}
