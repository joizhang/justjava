package com.joizhang.imooc;

import com.joizhang.imooc.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthenticationTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void setUp() {
        simpleAccountRealm.addAccount(
                "Mark",
                "123456",
                "admin",
                "user");
    }

    @Test
    public void testSha256() {

        Sha256Hash sha256Hash = new Sha256Hash("123456");
        // SHA-256 设置 iteration 并不生效
        sha256Hash.setIterations(1);
        System.out.println(sha256Hash.toString());

        SimpleHash simpleHash = new SimpleHash(Sha256Hash.ALGORITHM_NAME, "123456", null, 1);
        System.out.println(simpleHash.toString());
    }

    @Test
    public void testMd5() {
        Md5Hash md5Hash = new Md5Hash("123456", "123");
        md5Hash.setIterations(2);
        System.out.println(md5Hash.toString());

        SimpleHash simpleHash = new SimpleHash(Md5Hash.ALGORITHM_NAME, "123456", "123", 2);
        System.out.println(simpleHash.toString());
    }

    /**
     * Shiro 认证
     */
    @Test
    public void testAuthentication() {
        CustomRealm customRealm = new CustomRealm();

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        matcher.setHashIterations(2);
        customRealm.setCredentialsMatcher(matcher);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        subject.login(token);

        assertTrue(subject.isAuthenticated());

        subject.logout();

        assertFalse(subject.isAuthenticated());
    }

    /**
     * Shiro 授权
     */
    @Test
    public void testAuthorization() {
        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        subject.checkRole("admin");
        subject.checkRole("user");
        subject.checkRoles("admin", "user");
    }

}
