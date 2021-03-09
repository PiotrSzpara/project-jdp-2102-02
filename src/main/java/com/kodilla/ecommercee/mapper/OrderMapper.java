package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto (
                order.getOrderId(),
                order.getOrderName(),
                order.isPaid(),
                order.getOrderDate()
        );
    }
}
