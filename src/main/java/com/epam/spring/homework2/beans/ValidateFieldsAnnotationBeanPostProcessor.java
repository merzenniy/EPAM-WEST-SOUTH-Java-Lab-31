package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.impl.CustomValidatorImpl;
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
                CustomValidatorImpl customValidator = new CustomValidatorImpl();
                Field nameField = bean.getClass().getDeclaredField("name");
                Field valueField = bean.getClass().getDeclaredField("value");

                nameField.setAccessible(true);
                valueField.setAccessible(true);

                String name = (String) nameField.get(bean);
                Integer value = (Integer) valueField.get(bean);
                customValidator.isNamePresent(name);
                customValidator.isValuePositive(value);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}


