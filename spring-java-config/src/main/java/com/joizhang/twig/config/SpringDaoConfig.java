package com.joizhang.twig.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringDaoConfig /*implements EnvironmentAware */ {

    private static Logger logger = LoggerFactory.getLogger(SpringDaoConfig.class);

    @Autowired
    private Environment environment;

    @Bean
    DataSource dataSource() throws SQLException {
        logger.info("Starting the initialization of the data source with {}...", environment);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setInitialSize(Integer.parseInt(environment.getProperty("druid.pool.size.init")));
        dataSource.setMinIdle(Integer.parseInt(environment.getProperty("druid.pool.size.min")));
        dataSource.setMaxActive(Integer.parseInt(environment.getProperty("druid.pool.size.max")));
        dataSource.setFilters("wall,stat");
        return dataSource;
    }

    @Bean
    @Autowired
    SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws SQLException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // mybatis config
        org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration();
        mybatisConfiguration.setUseGeneratedKeys(true);
        mybatisConfiguration.setUseColumnLabel(true);
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.joizhang.twig.entity");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

}
