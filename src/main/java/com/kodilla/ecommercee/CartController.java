package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    public CartController(){}

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newCart() {
        System.out.println("koszyk stworzony");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromEmptyCart")
    public void getProductFromEmptyCart() {
        System.out.println("elementy pobrane???");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct() {
        System.out.println("produkt dodany");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void removeProduct() {
        System.out.println("produkt usuniety");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder() {
        System.out.println("zamowienie stworzone");
    }


}
