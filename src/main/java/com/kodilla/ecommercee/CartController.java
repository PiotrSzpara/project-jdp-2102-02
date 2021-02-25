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
    public void newCart(int id) {
        System.out.println("koszyk" + id + " stworzony");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromEmptyCart")
    public void getProductFromEmptyCart() {
        System.out.println("elementy pobrane???");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(int id) {
        System.out.println("produkt" + id + " dodany");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void removeProduct() {
        System.out.println("produkt usuniety");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(int id) {
        System.out.println("zamowienie" + id + " stworzone");
    }


}
