package com.kodilla.ecommercee;



import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDao;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
public class ProductDaoTests {

    @Autowired
    private ProductDao productDao ;

    @Test
    public void testProductDaoSave() {
        //Given
        Product product = new Product("produkt testowy","opis produktu testowego",2.20);

        //When
        productDao.save(product);

        //Then
        String name = product.getProductName();
        List<Product> readProduct = productDao.findByProductName(name);
        assertFalse(readProduct.isEmpty());

    }
}
