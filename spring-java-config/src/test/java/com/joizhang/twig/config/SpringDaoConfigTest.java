package com.joizhang.twig.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDaoConfig.class)
public class SpringDaoConfigTest {

    @Autowired
    private Environment environment;

    @Autowired
    private DruidDataSource dataSource;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void testSqlSessionFactory() {
        assertNotNull(sqlSessionFactoryBean);
    }

    @Test
    public void testDataSourceTransactionManager() {
        assertNotNull(dataSourceTransactionManager);
    }

    @Test
    public void testGetProperty() {
        assertNotNull(environment);
    }
}