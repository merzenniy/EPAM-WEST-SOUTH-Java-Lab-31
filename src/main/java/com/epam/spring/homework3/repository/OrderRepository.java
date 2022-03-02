package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Order;

import java.util.List;

public interface OrderRepository {
    Order getOrder(int id);

    List<Order> getOrdersList();

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
