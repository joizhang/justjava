package com.joizhang.imooc.config;

import com.joizhang.imooc.realm.CustomRealm;
import com.joizhang.imooc.session.RedisSessionDao;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

import static org.apache.shiro.codec.Base64.decode;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm getRealm() {
        return new CustomRealm();
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(2592000);
        return cookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        rememberMeManager.setCipherKey(decode("5AvVhmFLUs0KTA3Kprsdag=="));
        return rememberMeManager;
    }

    @Bean
    public SessionManager sessionManager() {
        return new DefaultWebSessionManager();
    }

    @Bean
    public DefaultWebSecurityManager webSecurityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getRealm());
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(webSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/Account/Login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/Account/Login");

        HashMap<String, String> map = new HashMap<>();
        map.put("/hello", "anon");
        map.put("/Account/**", "anon");
        map.put("/login", "anon");
        map.put("/assets/**", "anon");
        map.put("/app/**", "anon");
        map.put("/**", "authc");//需要登陆
        //map.put("/**", "user");//通过记住我登陆

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
