package com.springdemo.mvc.config;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@RequiredArgsConstructor
public class TransactionManagerConfig {
    final SessionFactory sessionFactory;

    @Bean
    public HibernateTransactionManager myTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
