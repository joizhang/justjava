package com.joizhang.twig.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan("com.joizhang.twig.cache")
@PropertySource("classpath:redis.properties")
public class SpringRedisCacheConfig implements EnvironmentAware {

    private static Logger logger = LoggerFactory.getLogger(SpringRedisCacheConfig.class);

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean
    JedisPoolConfig jedisPoolConfig() {
        logger.info("Starting the initialization of redis config");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(env.getProperty("redis.pool.maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(env.getProperty("redis.pool.maxIdle")));
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(env.getProperty("redis.pool.maxWaitMillis")));
        jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("redis.pool.testOnBorrow")));
        return jedisPoolConfig;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(env.getProperty("redis.ip"));
        jedisConnectionFactory.setPort(Integer.parseInt(env.getProperty("redis.port")));
        jedisConnectionFactory.setPassword(env.getProperty("redis.pass"));
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        return jedisConnectionFactory;
    }

    @Bean
    StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return stringRedisTemplate;
    }

}
