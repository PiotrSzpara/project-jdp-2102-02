package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class OrderDto {

    private int orderId;
    private String orderName;
    private boolean isPaid;
    private Date orderDate;
}
