package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDto {

    private int orderId;
    private String orderName;
    private boolean isPaid;
    private Date orderDate;
    private Cart cart;
    private List<Product> products;
}
