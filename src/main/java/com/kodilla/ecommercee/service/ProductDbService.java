package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDao;
import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    private final ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product findProduct(int productId) {
        return productDao.findById(productId);
    }

    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    public void deleteProduct(int productId) {
        productDao.deleteById(productId);
    }
}
