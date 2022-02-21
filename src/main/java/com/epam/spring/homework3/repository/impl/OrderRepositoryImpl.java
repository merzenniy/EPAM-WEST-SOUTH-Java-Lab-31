package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.ItemNotFoundException;
import com.epam.spring.homework3.model.Client;
import com.epam.spring.homework3.model.Order;
import com.epam.spring.homework3.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders  = new ArrayList<>();

    @Override
    public Order getOrder(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getOrder method");
        return orders.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Can`t found order with id = " + id));    }

    @Override
    public List<Order> ordersList() {
        log.info(this.getClass().getSimpleName() + ". Inside ordersList method");
        return new ArrayList<>(orders);
    }

    @Override
    public Order createOrder(Order order) {
        log.info(this.getClass().getSimpleName() + ". Inside createOrder method");
        orders.add(order);
        return order;    }

    @Override
    public Order updateOrder(int id, Order order) {
        log.info(this.getClass().getSimpleName() + ". Inside updateClient method");
        boolean isChanged = orders.removeIf(order1 -> order1.getId() == id);
        if (isChanged) {
            orders.add(order);
        } else {
            throw new ItemNotFoundException("Order with given id does not exist");
        }
        return order;    }

    @Override
    public void deleteOrder(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteOrder method");
        orders.removeIf(order -> order.getId() == id);
    }
}
