package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import com.epam.spring.homework2.validator.impl.BeanValidatorImpl;
import org.springframework.stereotype.Component;

@Component
public class BeanF implements BeanValidator {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + ". validate method");
        BeanValidatorImpl.validate(this.getClass().getSimpleName(), this.name, this.value);
    }
}
