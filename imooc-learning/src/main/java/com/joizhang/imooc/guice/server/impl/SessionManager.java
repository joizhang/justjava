package com.joizhang.imooc.guice.server.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * @author imooc
 */
public class SessionManager {

    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(@SessionId Provider<Long> sessionIdProvider) {
        this.sessionIdProvider = sessionIdProvider;
    }

    public Long getSessionId() {
        return sessionIdProvider.get();
    }
}
