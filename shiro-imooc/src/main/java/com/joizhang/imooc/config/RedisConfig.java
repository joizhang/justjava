package com.joizhang.imooc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    private final Environment environment;

    @Autowired
    public RedisConfig(Environment environment) {
        this.environment = environment;
    }

    private String getPropertyFormEnv(String propertyName) {
        return environment.getProperty(propertyName);
    }

    private int getIntPropertyFormEnv(String propertyName) {
        return Integer.parseInt(environment.getProperty(propertyName));
    }

    @Bean
    @Primary
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(connectionFactory());
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName(getPropertyFormEnv("redis.host"));
        connection.setPassword(getPropertyFormEnv("redis.passWord"));
        connection.setPort(getIntPropertyFormEnv("redis.port"));
        connection.setTimeout(getIntPropertyFormEnv("redis.timeout"));
        connection.setDatabase(getIntPropertyFormEnv("redis.database"));
        connection.setPoolConfig(jedisPoolConfig());
        return connection;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(getIntPropertyFormEnv("redis.maxTotal"));
        jedisPoolConfig.setMaxIdle(getIntPropertyFormEnv("redis.maxIdle"));
        jedisPoolConfig.setMaxWaitMillis(getIntPropertyFormEnv("redis.maxWaitMillis"));
        jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("redis.testOnBorrow")));
        return jedisPoolConfig;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public JdkSerializationRedisSerializer jdkSerializationRedisSerializer() {
        return new JdkSerializationRedisSerializer();
    }

}
