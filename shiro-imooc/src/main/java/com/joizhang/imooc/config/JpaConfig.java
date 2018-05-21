package com.joizhang.imooc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class JpaConfig {

    private final Environment environment;

    @Autowired
    public JpaConfig(Environment environment) {
        this.environment = environment;
    }

    private String getPropertyFormEnv(String propertyName) {
        return environment.getProperty(propertyName);
    }

    private int getIntPropertyFormEnv(String propertyName) {
        return Integer.parseInt(environment.getProperty(propertyName));
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(getPropertyFormEnv("jdbc.userName"));
        dataSource.setPassword(getPropertyFormEnv("jdbc.password"));
        dataSource.setUrl(getPropertyFormEnv("jdbc.connectionURL"));
        dataSource.setDriverClassName(getPropertyFormEnv("jdbc.driverClass"));
        dataSource.setInitialSize(getIntPropertyFormEnv("jdbc.initialPoolSize"));
        dataSource.setMaxActive(getIntPropertyFormEnv("jdbc.maxPoolSize"));
        return dataSource;
    }

    /**
     * 配置 Hibernate 的 SessionFactory 实例: 通过 Spring 提供的 LocalSessionFactoryBean 进行配置
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        //配置数据源属性
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, getPropertyFormEnv("hibernate.show_sql"));
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, getPropertyFormEnv("hibernate.format_sql"));
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, getPropertyFormEnv("hibernate.hbm2ddl.auto"));
//        jpaProperties.put(org.hibernate.cfg.Environment.USE_SECOND_LEVEL_CACHE, true);
//        jpaProperties.put(org.hibernate.cfg.Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.SingletonEhCacheRegionFactory");
//        jpaProperties.put(org.hibernate.cfg.Environment.USE_QUERY_CACHE, true);
        jpaProperties.put(org.hibernate.cfg.Environment.ISOLATION, 2);
        jpaProperties.put(org.hibernate.cfg.Environment.USE_IDENTIFIER_ROLLBACK, true);

        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);


        //通过扫描下面这个包的方式注册到Hibernate
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.github.izhangzhihao.SpringMVCSeedProject.Model");
        return localContainerEntityManagerFactoryBean;
    }

    /**
     * 配置 Spring 事务管理器
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

}
