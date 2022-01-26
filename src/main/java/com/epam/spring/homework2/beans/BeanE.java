package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import com.epam.spring.homework2.validator.impl.BeanValidatorImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements BeanValidator {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " @PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " @PreDestroy method");
    }

    @Override
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + ". validate method");
        BeanValidatorImpl.validate(this.getClass().getSimpleName(), this.name, this.value);
    }
}
