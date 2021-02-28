package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class OrderDto {

    int orderId;
    Date orderDate;

}
