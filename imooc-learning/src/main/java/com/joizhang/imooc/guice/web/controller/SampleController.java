package com.joizhang.imooc.guice.web.controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.joizhang.imooc.guice.guicedi.MyApplet;
import com.joizhang.imooc.guice.web.SpringScanBase;
import com.joizhang.imooc.guice.web.greeting.GreetingHandler;
import com.joizhang.imooc.guice.web.greeting.HelloWorldModule;
import com.joizhang.imooc.guice.web.greeting.WebDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author imooc
 */
@RestController
@SpringBootApplication(scanBasePackageClasses = SpringScanBase.class)
@ServletComponentScan
public class SampleController {

    @Bean Injector injector(ApplicationContext context) {
        return Guice.createInjector(
                new HelloWorldModule(),
                new SpringAwareServletModule(context));
    }

    @Bean
    @RequestScope
    MyApplet applet(Injector injector) {
        return injector.getInstance(MyApplet.class);
    }

    @Bean
    @RequestScope
    WebDestination destination(Injector injector) {
        return injector.getInstance(WebDestination.class);
    }

    @Bean
    @RequestScope
    GreetingHandler greetingHandler(Injector injector) {
        return injector.getInstance(GreetingHandler.class);
    }

    @Autowired GreetingHandler greetingHandler;

    @GetMapping("/greeting")
    String greeting(@RequestParam("name") String name) {
        return greetingHandler.getByName(name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}