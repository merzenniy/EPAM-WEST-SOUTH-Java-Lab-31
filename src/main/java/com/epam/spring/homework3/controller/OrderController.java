package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.ClientDTO;
import com.epam.spring.homework3.dto.OrderDTO;
import com.epam.spring.homework3.service.ClientService;
import com.epam.spring.homework3.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrder(@PathVariable int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getOrder method");
        return orderService.getOrder(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order")
    public List<OrderDTO> getAllOrders() {
        log.info(this.getClass().getSimpleName() + ". Inside getAllOrders method");
        return orderService.ordersList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside createOrder method");
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDTO updateOrder(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside updateOrder method");
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteOrder method");
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}