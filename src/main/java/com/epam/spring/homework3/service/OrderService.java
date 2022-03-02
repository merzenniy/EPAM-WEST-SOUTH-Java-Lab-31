package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.OrderDTO;
import com.epam.spring.homework3.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO getOrder(int id);

    List<OrderDTO> getOrdersList();

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(int id, OrderDTO orderDTO);

    void deleteOrder(int id);
}
