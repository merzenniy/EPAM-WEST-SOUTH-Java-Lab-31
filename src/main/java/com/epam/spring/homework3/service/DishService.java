package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.DishDTO;

import java.util.List;

public interface DishService {

    DishDTO getDish(int id);

    List<DishDTO> getDishesList();

    DishDTO createDish(DishDTO dishDTO);

    DishDTO updateDish(int id, DishDTO dishDTO);

    void deleteDish(int id);
}
