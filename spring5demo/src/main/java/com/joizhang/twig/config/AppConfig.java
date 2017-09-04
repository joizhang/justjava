package com.joizhang.twig.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableSpringConfigured
@EnableLoadTimeWeaving
@Import(value = {
        SpringDaoConfig.class,
        SpringServiceConfig.class
})
public class AppConfig {

}
