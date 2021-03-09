package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CartDto {

    int cartId;
    private List<Product> products = new ArrayList<>();
    private User user;
    private Order order;
}
