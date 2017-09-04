package com.joizhang.twig;

import com.alibaba.druid.pool.DruidDataSource;
import com.joizhang.twig.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {

    @Autowired
    private PropertiesFactoryBean propertiesFactoryBean;

    @Autowired
    private DruidDataSource dataSource;

    @Test
    public void propertiesFactoryBean() throws Exception {
        assertNotNull(propertiesFactoryBean);
    }

    @Test
    public void dataSource() throws Exception {
        assertNotNull(dataSource);
    }

}