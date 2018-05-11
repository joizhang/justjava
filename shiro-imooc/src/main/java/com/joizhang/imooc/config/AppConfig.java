package com.joizhang.imooc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringConfig.class, SpringWebConfig.class})
public class AppConfig {
}
