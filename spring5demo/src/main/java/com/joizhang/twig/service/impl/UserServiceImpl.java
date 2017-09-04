package com.joizhang.twig.service.impl;

import com.joizhang.twig.dao.UserDao;
import com.joizhang.twig.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public void sayHello() {
        logger.info("Hello!!!");
    }
}
