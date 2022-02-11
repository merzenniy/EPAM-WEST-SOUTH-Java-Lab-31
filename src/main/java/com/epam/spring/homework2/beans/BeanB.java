package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

@ValidateFields

public class BeanB{
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


}
