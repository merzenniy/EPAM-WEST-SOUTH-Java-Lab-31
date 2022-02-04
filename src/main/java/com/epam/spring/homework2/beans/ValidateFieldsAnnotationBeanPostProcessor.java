package com.epam.spring.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class ValidateFieldsAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ValidateFields.class)) {
            try {
                Field nameField = bean.getClass().getDeclaredField("name");
                Field valueField = bean.getClass().getDeclaredField("value");

                nameField.setAccessible(true);
                valueField.setAccessible(true);

                String name = (String) nameField.get(bean);
                Integer value = (Integer) valueField.get(bean);

                if (name == null) {
                    System.out.println(bean.getClass().getSimpleName() + " is not valid. " + " Name can not be null");

                } else if (value <= 0) {
                    System.out.println(bean.getClass().getSimpleName() + " is not valid. " + " Value must be greater than 0");

                } else {
                    System.out.println(bean.getClass().getSimpleName() + " is valid!)");
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}


