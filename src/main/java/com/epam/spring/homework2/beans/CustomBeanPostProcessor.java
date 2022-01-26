package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getSimpleName() + " BeanPostProcessor postProcessBeforeInitialization method");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getSimpleName() + " BeanPostProcessor postProcessAfterInitialization method");
        if (bean instanceof BeanValidator) {
            ((BeanValidator) bean).validate();
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
