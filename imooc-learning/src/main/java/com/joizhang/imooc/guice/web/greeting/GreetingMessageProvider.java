package com.joizhang.imooc.guice.web.greeting;

import com.joizhang.imooc.guice.web.persistence.SampleDao;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * @author imooc
 */
public class GreetingMessageProvider implements Provider<String> {

    private final RequestParams params;
    private final SampleDao dao;

    @Inject
    public GreetingMessageProvider(RequestParams params, SampleDao dao) {
        this.params = params;
        this.dao = dao;
    }

    @Override
    public String get() {
        String greetingName = params.getGreetingName();
        dao.getPersonData(greetingName);
        return "Hello " + greetingName;
    }
}
