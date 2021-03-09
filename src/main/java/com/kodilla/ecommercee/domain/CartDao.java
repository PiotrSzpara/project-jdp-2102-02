package com.kodilla.ecommercee.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

    Cart findById(int id);

    Product findProductfromCart(int productId);

    void addProductToCart(Product product);

    void removeProductToCart(Product product);

    void createOrder(int orderId);

}
