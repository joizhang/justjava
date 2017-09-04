package com.joizhang.dao.cache;

import com.joizhang.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RedisDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void getSeckill() throws Exception {

    }

    @Test
    public void putSeckill() throws Exception {

    }

}