package com.springdemo.mvc.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.springdemo.mvc")
@PropertySource({"classpath:/countries.properties", "classpath:/languages.properties"})
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public PropertiesFactoryBean countryOptions() {
        PropertiesFactoryBean countryOptions = new PropertiesFactoryBean();
        countryOptions.setLocation(new ClassPathResource("countries.properties"));
        return countryOptions;
    }

    @Bean
    public PropertiesFactoryBean languageOptions() {
        PropertiesFactoryBean languageOptions = new PropertiesFactoryBean();
        languageOptions.setLocation(new ClassPathResource("languages.properties"));
        return languageOptions;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
