package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class DishDto {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private int calories;

    @NotNull
    @NotBlank
    private String ingredients;

    @NotNull
    private Category category;

}