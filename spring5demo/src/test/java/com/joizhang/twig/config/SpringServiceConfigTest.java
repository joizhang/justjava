package com.joizhang.twig.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = SpringDaoConfig.class),
        @ContextConfiguration(classes = SpringServiceConfig.class) })
public class SpringServiceConfigTest {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Test
    public void testDataSourceTransactionManager() {
        assertNotNull(dataSourceTransactionManager);
    }

}