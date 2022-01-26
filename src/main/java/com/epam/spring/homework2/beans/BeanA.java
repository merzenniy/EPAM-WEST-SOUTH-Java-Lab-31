package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeanValidator;
import com.epam.spring.homework2.validator.impl.BeanValidatorImpl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, BeanValidator {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " destroy method from DisposableBean interface");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " afterPropertiesSet method from InitializingBean interface");
    }


    @Override
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + ". validate method");
        BeanValidatorImpl.validate(this.getClass().getSimpleName(), this.name, this.value);
    }
}
