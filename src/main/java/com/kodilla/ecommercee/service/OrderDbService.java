package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrder(int orderId) {
        return orderDao.findById(orderId);
    }

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public void deleteOrderById(int orderId) {
        orderDao.deleteById(orderId);
    }
}
