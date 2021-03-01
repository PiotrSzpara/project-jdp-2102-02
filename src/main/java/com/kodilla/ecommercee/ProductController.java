package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        return products;
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("productId") int productId) {
        return new ProductDto(productId, "telefon", 2000, "smartphone");
    }

    @PostMapping(value = "createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productDto;
        return updatedProduct;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("productId") int productId) {
        System.out.println("Deleted product # " + productId);
    }
}
