package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.DishDTO;
import com.epam.spring.homework3.service.DishService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/dish/{id}")
    public DishDTO getDish(@PathVariable int id){
        log.info(this.getClass().getSimpleName() + ". Inside getDish method");
        return dishService.getDish(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/dishes")
    public List<DishDTO> getAllDishes(){
        log.info(this.getClass().getSimpleName() + ". Inside getAllDishes method");
        return dishService.getDishesList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/dish")
    public DishDTO createDish(@RequestBody DishDTO dishDTO){
        log.info(this.getClass().getSimpleName() + ". Inside createDish method");
        return dishService.createDish(dishDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/dish/{id}")
    public DishDTO updateDish(@PathVariable int id, @RequestBody DishDTO dishDTO){
        log.info(this.getClass().getSimpleName() + ". Inside updateDish method");
        return dishService.updateDish(id, dishDTO);
    }

    @DeleteMapping(value = "/dish/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable int id){
        log.info(this.getClass().getSimpleName() + ". Inside deleteDish method");
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}