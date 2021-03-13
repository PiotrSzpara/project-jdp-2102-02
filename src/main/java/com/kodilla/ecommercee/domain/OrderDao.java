package com.kodilla.ecommercee.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

    Order findById(int orderId);

    @Override
    Order save(Order order);

    @Override
    List<Order> findAll();

}
