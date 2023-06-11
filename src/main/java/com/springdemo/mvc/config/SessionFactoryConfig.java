package com.springdemo.mvc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class SessionFactoryConfig {
    final ComboPooledDataSource myDataSource;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource);
        sessionFactory.setPackagesToScan("com.springdemo.mvc.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
