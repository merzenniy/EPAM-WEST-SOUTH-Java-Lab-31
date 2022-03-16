package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dish {
    private int id;
    private String name;
    private int calories;
    private String ingredients;
    private Category category;
}
