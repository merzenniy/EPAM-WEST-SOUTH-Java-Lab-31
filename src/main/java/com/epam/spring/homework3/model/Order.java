package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
public class Order {
    private int id;
    private Date dateOfOrder;
    private ArrayList<Dish> dishes;
    private Client client;
}
