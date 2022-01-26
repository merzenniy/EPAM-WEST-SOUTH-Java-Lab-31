package com.epam.spring.homework2.validator.impl;

import com.epam.spring.homework2.validator.BeanValidator;

public class BeanValidatorImpl implements BeanValidator {

    public static void validate(String className, String name, int value) {
        if (name != null && value > 0) {
            System.out.println(className + " successfully validated");
        } else {
            System.out.println(className + " unsuccessfully validated");
        }
    }

    @Override
    public void validate() {

    }
}

