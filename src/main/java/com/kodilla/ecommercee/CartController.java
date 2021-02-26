package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    public CartController(){}

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto newCart(int id) {
        return new CartDto(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromEmptyCart")
    public ProductDto getProductFromEmptyCart() {
        return new ProductDto(1,"pralka",899,"najnowsza i tak dalej");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(int id) {
        List<ProductDto> products = new LinkedList<>();
        ProductDto product = new ProductDto(1,"pralka",899,"najnowsza i tak dalej");
        products.add(product);
        System.out.println(product + " dodany");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProduct")
    public void removeProduct(int id) {
        System.out.println("produkt" + id +" usuniety");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(int id) {
        return new OrderDto(id,new Date());
    }


}
