package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.DishDTO;
import com.epam.spring.homework3.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    DishDTO mapDishDTO (Dish dish);

    Dish mapDish (DishDTO dishDTO);

    List<DishDTO> mapDishDTOs(List<Dish> dishes);
}