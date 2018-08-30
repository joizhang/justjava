package com.joizhang.imooc.config;

import com.joizhang.imooc.Application;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumSet;

/**
 * @author joizhang
 */
public class JettyServer {

    private static final int PORT = 8080;

    private static final String CONTEXT_PATH = "/";

    private static final String MAPPING_URL = "/*";

    private static final String SERVLET_MAPPING_URL = "/";

    public void run() throws Exception {
        Server server = new Server();
        //JVM退出时关闭Jetty
        server.setStopAtShutdown(true);
        try(ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(PORT);
            connector.setReuseAddress(false);
            server.setConnectors(new Connector[]{connector});
            server.setHandler(webAppContext(springApplicationContext()));
            server.start();
            server.join();
        }
    }

    private WebAppContext webAppContext(WebApplicationContext context) throws MalformedURLException {
        WebAppContext webAppContext = new WebAppContext("webapp", CONTEXT_PATH);
        webAppContext.setBaseResource(Resource.newResource(new URL(Application.class.getResource("/webapp/WEB-INF"), ".")));
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        webAppContext.addEventListener(new ContextLoaderListener(context));

        FilterHolder filterHolder = new FilterHolder(DelegatingFilterProxy.class);
        filterHolder.setName("shiroFilter");
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE);
        webAppContext.addFilter(filterHolder, MAPPING_URL, dispatcherTypes);

        webAppContext.addServlet(new ServletHolder(new DispatcherServlet(context)), SERVLET_MAPPING_URL);

        return webAppContext;
    }

    private WebApplicationContext springApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        context.register(SpringWebConfig.class);
        return context;
    }

}