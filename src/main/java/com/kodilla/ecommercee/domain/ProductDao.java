
package com.kodilla.ecommercee.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductDao extends CrudRepository <Product, Integer> {

    Product findById(int productId);

    List<Product> findByProductName(String productName);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);
}