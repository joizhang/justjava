package com.joizhang.imooc.guice.server.impl;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class SessionManagerTest {

    @Inject SessionManager sessionManager;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void getSessionId() throws Exception {
        Long sessionId = sessionManager.getSessionId();
        Thread.sleep(1000);
        Long sessionId2 = sessionManager.getSessionId();
        assertNotEquals(sessionId.longValue(), sessionId2.longValue());
    }

}