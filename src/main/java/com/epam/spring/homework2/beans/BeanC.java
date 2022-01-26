package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import com.epam.spring.homework2.validator.impl.BeanValidatorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements BeanValidator {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void cInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " InitMetod");
    }

    private void cDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " Destroy method");
    }

    @Override
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + " validate method");
        BeanValidatorImpl.validate(this.getClass().getSimpleName(), this.name, this.value);
    }
}
