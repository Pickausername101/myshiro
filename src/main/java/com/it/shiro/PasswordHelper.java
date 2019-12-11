package com.it.shiro;

import com.it.shiro.pojo.Sys_users;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

/**
 * <P>
 *     加密工具
 * </P>
 * @Author 王文龙
 * @Date 2019-11-27 16:04
 */
@Configuration
public class  PasswordHelper {

    static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    static String algorithmName = "md5";
    static final int hashIterations = 2;

    public void encryptPassword(Sys_users sys_users) {

        sys_users.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                sys_users.getPassword(),
                ByteSource.Util.bytes(sys_users.getCredentialsSalt()),
                hashIterations).toHex();

        sys_users.setPassword(newPassword);
    }
}
