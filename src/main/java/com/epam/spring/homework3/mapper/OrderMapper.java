package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.OrderDTO;
import com.epam.spring.homework3.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO mapOrderDTO (Order order);

    Order mapOrder (OrderDTO orderDto);

    List<OrderDTO> mapOrderDTOs(List<Order> orders);
}