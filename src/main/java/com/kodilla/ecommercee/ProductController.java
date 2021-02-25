package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @GetMapping(name = "getAllProducts")
    public void getAllProducts() {
        System.out.println("returns list of all products");
    }

    @GetMapping(name = "getProduct")
    public void getProduct(Long id) {
        System.out.println("returns one product with provided " + id);
    }

    @PostMapping(name = "createProduct")
    public void createProduct() {
        System.out.println("creates a product");
    }

    @PutMapping(name = "updateProduct")
    public void updateProduct(Long id) {
        System.out.println("updates a product data with provided " + id);
    }

    @DeleteMapping(name = "deleteProduct")
    public void deleteProduct(Long id) {
        System.out.println("deletes a product with provided " + id);
    }
}
