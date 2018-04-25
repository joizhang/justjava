package com.joizhang.twig.core;


import com.joizhang.twig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeTask {

    private final UserService userService;

    @Autowired
    public SomeTask(UserService userService) {
        this.userService = userService;
    }

    public void execute() {
    }
}
