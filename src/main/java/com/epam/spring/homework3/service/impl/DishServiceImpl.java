package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.DishDTO;
import com.epam.spring.homework3.mapper.DishMapper;
import com.epam.spring.homework3.model.Dish;
import com.epam.spring.homework3.repository.DishRepository;
import com.epam.spring.homework3.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    @Override
    public DishDTO getDish(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getDish method");
        Dish dish = dishRepository.getDish(id);
        return DishMapper.INSTANCE.mapDishDTO(dish);
    }

    @Override
    public List<DishDTO> dishesList() {
        log.info(this.getClass().getSimpleName() + ". Inside dishesList method");
        return DishMapper.INSTANCE.mapDishDTOs(dishRepository.dishesList());
    }

    @Override
    public DishDTO createDish(DishDTO dishDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside createDish method");
        Dish dish = DishMapper.INSTANCE.mapDish(dishDTO);
        dish = dishRepository.createDish(dish);
        return DishMapper.INSTANCE.mapDishDTO(dish);
    }

    @Override
    public DishDTO updateDish(int id, DishDTO dishDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside updateDish method");
        Dish dish = DishMapper.INSTANCE.mapDish(dishDTO);
        dish = dishRepository.updateDish(id, dish);
        return DishMapper.INSTANCE.mapDishDTO(dish);
    }

    @Override
    public void deleteDish(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteDish method");
        dishRepository.deleteDish(id);
    }
}
