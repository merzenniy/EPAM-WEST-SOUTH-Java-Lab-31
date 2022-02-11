package com.epam.spring.homework2.validator;

public interface CustomValidator {
    boolean isNamePresent(String name);
    boolean isValuePositive(int value);
}