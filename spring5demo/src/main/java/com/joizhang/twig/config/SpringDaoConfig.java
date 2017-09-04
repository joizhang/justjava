package com.joizhang.twig.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class SpringDaoConfig implements EnvironmentAware {

    private static Logger logger = LoggerFactory.getLogger(SpringDaoConfig.class);

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        logger.info("Starting the initialization of the data source...");
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("druid.pool.size.init")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("druid.pool.size.min")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("druid.pool.size.max")));
        dataSource.setFilters("wall,stat");
        return dataSource;
    }

    @Bean("sqlSessionFactory")
    SqlSessionFactoryBean sqlSessionFactory() throws SQLException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        // mybatis config
        org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration();
        mybatisConfiguration.setUseGeneratedKeys(true);
        mybatisConfiguration.setUseColumnLabel(true);
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.joizhang.twig.entity");
        //sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    MapperScannerConfigurer mapperScannerConfigurer() throws IOException, SQLException {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.joizhang.twig.dao");
        return mapperScannerConfigurer;
    }
}
