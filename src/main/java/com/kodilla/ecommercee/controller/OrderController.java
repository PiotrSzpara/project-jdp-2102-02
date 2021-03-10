package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDbService service;
    private final OrderMapper orderMapper;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = service.getAllOrders();
        return orderMapper.mapToOrderDtoList(orders);
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam int orderId) {
        return orderMapper.mapToOrderDto(service.getOrder(orderId));
    }

    @PostMapping(value = "postOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        service.saveOrder(order);
    }

    @PutMapping(value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = service.saveOrder(order);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") int orderId) {
        service.deleteOrderById(orderId);
    }
}
