package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import com.epam.spring.homework2.validator.impl.BeanValidatorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements BeanValidator {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void bInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " InitMetod");
    }

    private void bDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " Destroy method");
    }

    @Override
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + ". validate method");
        BeanValidatorImpl.validate(this.getClass().getSimpleName(), this.name, this.value);
    }
}
