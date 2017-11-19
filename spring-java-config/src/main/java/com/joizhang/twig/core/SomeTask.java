package com.joizhang.twig.core;


import com.joizhang.twig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeTask {

    @Autowired
    private UserService userService;

    public void execute() {
    }
}
