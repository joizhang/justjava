package com.joizhang.imooc.config;

import com.joizhang.imooc.realm.ShiroRealm;
import com.joizhang.imooc.session.*;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;
import java.util.HashMap;

import static org.apache.shiro.codec.Base64.decode;

@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager webSecurityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getRealm());
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm getRealm() {
        return new ShiroRealm();
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        rememberMeManager.setCipherKey(decode("5AvVhmFLUs0KTA3Kprsdag=="));
        return rememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(2592000);
        return cookie;
    }

    @Bean
    public SessionManager sessionManager(CachingShiroSessionDao cachingShiroSessionDao,
                                         ShiroSessionListener shiroSessionListener) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800);
        sessionManager.setDeleteInvalidSessions(false);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionValidationInterval(1800);
        sessionManager.setSessionFactory(sessionFactory());
        sessionManager.setSessionDAO(cachingShiroSessionDao);
        sessionManager.setSessionIdCookie(new SimpleCookie("SHRIOSESSIONID"));
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionListeners(Collections.singletonList(shiroSessionListener));
        return sessionManager;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new ShiroSessionFactory();
    }

    @Bean
    public CachingShiroSessionDao cachingShiroSessionDao(ShiroSessionRepository shiroSessionRepository) {
        CachingShiroSessionDao cachingShiroSessionDao = new CachingShiroSessionDao();
        cachingShiroSessionDao.setSessionRepository(shiroSessionRepository);
        return cachingShiroSessionDao;
    }

    @Bean
    public ShiroSessionRepository shiroSessionRepository(RedisTemplate redisTemplate) {
        ShiroSessionRepository shiroSessionRepository = new ShiroSessionRepository();
        assert redisTemplate != null;
        shiroSessionRepository.setRedisTemplate(redisTemplate);
        return shiroSessionRepository;
    }

    @Bean
    public ShiroSessionListener shiroSessionListener(CachingShiroSessionDao cachingShiroSessionDao,
                                                     ShiroSessionService shiroSessionService) {
        ShiroSessionListener shiroSessionListener = new ShiroSessionListener();
        shiroSessionListener.setSessionDao(cachingShiroSessionDao);
        shiroSessionListener.setShiroSessionService(shiroSessionService);
        return shiroSessionListener;
    }

    @Bean
    public ShiroSessionService shiroSessionService(RedisTemplate redisTemplate,
                                                   CachingShiroSessionDao cachingShiroSessionDao) {
        ShiroSessionService shiroSessionService = new ShiroSessionService();
        shiroSessionService.setRedisTemplate(redisTemplate);
        shiroSessionService.setSessionDao(cachingShiroSessionDao);
        return shiroSessionService;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(webSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        HashMap<String, String> map = new HashMap<>();
        map.put("/hello", "anon");
        map.put("/login", "anon");
        map.put("/assets/**", "anon");
        map.put("/app/**", "anon");
        //需要登陆
        map.put("/**", "authc");
        //map.put("/**", "user");//通过记住我登陆

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
