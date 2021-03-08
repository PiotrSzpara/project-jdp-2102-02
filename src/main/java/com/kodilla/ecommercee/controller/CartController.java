package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    public CartController(){}

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto newCart(@RequestParam("cartId") int cartId) {
        return new CartDto(cartId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromEmptyCart")
    public ProductDto getProductFromEmptyCart(@RequestParam("productId") int productId) {
        return new ProductDto(productId,"pralka",899,"najnowsza i tak dalej");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestParam("productId") int productId) {
        List<ProductDto> products = new LinkedList<>();
        ProductDto product = new ProductDto(productId,"pralka",899,"najnowsza i tak dalej");
        products.add(product);
        System.out.println(product + " dodany");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProduct")
    public void removeProduct(@RequestParam("productId") int productId) {
        System.out.println("produkt" + productId +" usuniety");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestParam("orderId") int orderId) {
        return new OrderDto(1, "Created test order name.", true, new Date());
    }


}
