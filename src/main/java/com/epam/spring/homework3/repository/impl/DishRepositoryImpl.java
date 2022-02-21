package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.ItemNotFoundException;
import com.epam.spring.homework3.model.Dish;
import com.epam.spring.homework3.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class DishRepositoryImpl implements DishRepository {
    private final List<Dish> dishes = new ArrayList<>();

    @Override
    public Dish getDish(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getDish method");
        return dishes.stream()
                .filter(dish -> dish.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Can`t found dish with id = " + id));
    }

    @Override
    public List<Dish> dishesList() {
        log.info(this.getClass().getSimpleName() + ". Inside dishesList method");
        return new ArrayList<>(dishes);
    }

    @Override
    public Dish createDish(Dish dish) {
        log.info(this.getClass().getSimpleName() + ". Inside createDish method");
        dishes.add(dish);
        return dish;
    }

    @Override
    public Dish updateDish(int id, Dish dish) {
        log.info(this.getClass().getSimpleName() + ". Inside updateDish method");
        boolean isChanged = dishes.removeIf(dish1 -> dish1.getId() == id);
        if (isChanged) {
            dishes.add(dish);
        } else {
            throw new ItemNotFoundException("Dish with given id = " + id + " does not exist");
        }
        return dish;
    }

    @Override
    public void deleteDish(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteDish method");
        dishes.removeIf(dish -> dish.getId() == id);
    }
}
