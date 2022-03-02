package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.OrderDTO;
import com.epam.spring.homework3.mapper.DishMapper;
import com.epam.spring.homework3.mapper.OrderMapper;
import com.epam.spring.homework3.model.Dish;
import com.epam.spring.homework3.model.Order;
import com.epam.spring.homework3.repository.DishRepository;
import com.epam.spring.homework3.repository.OrderRepository;
import com.epam.spring.homework3.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrder(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getOrder method");
        Order order = orderRepository.getOrder(id);
        return OrderMapper.INSTANCE.mapOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getOrdersList() {
        log.info(this.getClass().getSimpleName() + ". Inside ordersList method");
        return OrderMapper.INSTANCE.mapOrderDTOs(orderRepository.getOrdersList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside createOrder method");
        Order order = OrderMapper.INSTANCE.mapOrder(orderDTO);
        order = orderRepository.createOrder(order);
        return OrderMapper.INSTANCE.mapOrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(int id, OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside UpdateOrder method");
        Order order = OrderMapper.INSTANCE.mapOrder(orderDTO);
        order = orderRepository.updateOrder(id, order);
        return OrderMapper.INSTANCE.mapOrderDTO(order);
    }

    @Override
    public void deleteOrder(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteOrder method");
        orderRepository.deleteOrder(id);
    }
}
