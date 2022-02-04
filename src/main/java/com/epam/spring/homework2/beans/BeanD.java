package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

@ValidateFields

public class BeanD {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void dInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " InitMetod");
    }

    private void dDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " Destroy method");
    }


}
