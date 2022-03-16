package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish getDish(int id);

    List<Dish> getDishesList();

    Dish createDish(Dish dish);

    Dish updateDish(int id, Dish dish);

    void deleteDish(int id);
}
