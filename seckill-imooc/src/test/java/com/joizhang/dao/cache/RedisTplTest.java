package com.joizhang.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedisTplTest.class)
public class RedisTplTest {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void set() throws Exception {
        String key = String key = "seckill:" + seckillId;
    }

}
