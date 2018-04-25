package com.joizhang.imooc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IniRealmTest {

    private Subject subject;

    private UsernamePasswordToken token;

    @Before
    public void setUp() {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        subject = SecurityUtils.getSubject();

        token = new UsernamePasswordToken("tom", "123456");
    }

    @Test
    public void testAuthentication() {
        subject.login(token);
        assertTrue(subject.isAuthenticated());

        subject.logout();
        assertFalse(subject.isAuthenticated());
    }

    @Test
    public void testAuthorization() {
        subject.login(token);
        subject.checkRole("admin");
        subject.checkPermission("user:del");
    }

}
