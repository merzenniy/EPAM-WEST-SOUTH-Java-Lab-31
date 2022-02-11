package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.CustomBeanFactoryPostProcessor;
import com.epam.spring.homework2.beans.ValidateFieldsAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {
    @Bean
    public ValidateFieldsAnnotationBeanPostProcessor validateFieldsAnnotationBeanPostProcessor() {
        return new ValidateFieldsAnnotationBeanPostProcessor();
    }

    @Bean
    public static CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
