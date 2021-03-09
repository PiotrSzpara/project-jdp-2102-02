package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order findById(int orderId) {
        return orderDao.findById(orderId);
    }

    public Order findOrderByName(String orderName) {
        return orderDao.findByOrderName(orderName);
    }

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(int orderId) {
        orderDao.deleteById(orderId);
    }
}
