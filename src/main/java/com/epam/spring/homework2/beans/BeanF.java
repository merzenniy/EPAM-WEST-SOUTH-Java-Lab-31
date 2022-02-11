package com.epam.spring.homework2.beans;

@ValidateFields

public class BeanF {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}
