package com.epam.spring.homework2.validator.impl;


import com.epam.spring.homework2.validator.CustomValidator;

public class CustomValidatorImpl implements CustomValidator {

    public  boolean isNamePresent(String name) {
        if (name == null) {
            System.out.println("Name of bean is not valid. Name can not be null");
            return false;
        } else {
            System.out.println("Name of bean is valid.");
            return true;
        }
    }

    public  boolean isValuePositive(int value) {
        if (value <= 0) {
            System.out.println("Value is not valid. Value must be greater than 0");
            return false;
        } else {
            System.out.println("Value of bean is valid.");
            return true;
        }
    }
}
