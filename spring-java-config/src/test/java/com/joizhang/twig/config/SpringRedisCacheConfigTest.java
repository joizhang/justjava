package com.joizhang.twig.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPoolConfig;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRedisCacheConfig.class)
public class SpringRedisCacheConfigTest {

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testJedisPoolConfig() throws Exception {
        assertNotNull(jedisPoolConfig);
    }

    @Test
    public void testJedisConnectionFactory() {
        assertNotNull(jedisConnectionFactory);
    }

    @Test
    public void testStringRedisTemplate() {
        assertNotNull(stringRedisTemplate);
    }

}