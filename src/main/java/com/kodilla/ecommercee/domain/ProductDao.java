package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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