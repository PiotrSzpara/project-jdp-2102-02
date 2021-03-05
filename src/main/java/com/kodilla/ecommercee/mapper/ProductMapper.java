package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;

import java.util.List;

public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getProductPrice()
                );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductDescription()
        );
    }

    //public List<ProductDto> mapToProductDtoList(final List<Product> products) {
      //  Group group = new Group();
        //return group.getProducts().stream();
    }
