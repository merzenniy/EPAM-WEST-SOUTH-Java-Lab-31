package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Client;
import com.epam.spring.homework3.model.Dish;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

public class OrderDto {

    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotNull
    private Date dateOfOrder;

    @NotNull
    private ArrayList<Dish> dishes;

    @NotNull
    private Client client;
}
