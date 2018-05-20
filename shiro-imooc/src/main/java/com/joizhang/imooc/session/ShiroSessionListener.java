package com.joizhang.imooc.session;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

@Slf4j
public class ShiroSessionListener implements SessionListener {

    @Setter
    private ShiroSessionService shiroSessionService;

    @Setter
    private CachingShiroSessionDao sessionDao;

    @Override
    public void onStart(final Session session) {
        // 会话创建时触发
        log.info("session {} onStart", session.getId());
    }

    @Override
    public void onStop(final Session session) {
        sessionDao.delete(session);
        shiroSessionService.sendUnCacheSessionMessage(session.getId());
        log.info("session {} onStop", session.getId());
    }

    @Override
    public void onExpiration(final Session session) {
        sessionDao.delete(session);
        shiroSessionService.sendUnCacheSessionMessage(session.getId());
        log.info("session {} onExpiration", session.getId());
    }

}
