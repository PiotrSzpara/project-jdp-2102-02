package com.kodilla.ecommercee.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository <Product, Integer> {

    Product findByProductName(String productName);

    @Override
    List<Product> findAll();

    Product findById(int productId);

    @Override
    Product save(Product product);
}
