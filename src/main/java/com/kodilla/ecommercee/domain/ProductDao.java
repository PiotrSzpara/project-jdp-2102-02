package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductDao extends CrudRepository <Product, Integer> {

    Product findById(int id);

    Product findByProductName(String productName);

    List<Product> findAll();
}