package com.joizhang.imooc.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomRealmTest {

    private Subject subject;

    private UsernamePasswordToken token;

    @Before
    public void setUp() {
        CustomRealm customRealm = new CustomRealm();

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        subject = SecurityUtils.getSubject();

        token = new UsernamePasswordToken("Mark", "123456");
    }

    @Test
    public void doGetAuthenticationInfo() {
        subject.login(token);
        assertTrue(subject.isAuthenticated());
    }

    @Test
    public void doGetAuthorizationInfo() {
        subject.login(token);
        subject.checkRoles("admin", "user");
        subject.checkPermissions("user:del", "user:add");
    }
}