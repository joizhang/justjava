package com.joizhang.twig.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDaoConfig.class)
public class SpringDaoConfigTest {

    @Autowired
    private DruidDataSource dataSource;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    private MapperScannerConfigurer mapperScannerConfigurer;

    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void testSqlSessionFactory() {
        assertNotNull(sqlSessionFactoryBean);
    }

    @Test
    public void testMapperScannerConfigurer() {
        assertNotNull(mapperScannerConfigurer);
    }
}