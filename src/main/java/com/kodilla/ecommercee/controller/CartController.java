package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private final CartDbService cartDbService;
    private final ProductDbService productDbService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    @Autowired
    public CartController(CartDbService cartDbService, ProductDbService productDbService, CartMapper cartMapper, ProductMapper productMapper, OrderMapper orderMapper) {
        this.cartDbService = cartDbService;
        this.productDbService = productDbService;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto newCart(@RequestParam("cartId") int cartId) {
        return cartMapper.mapToCartDto(cartDbService.createCart(cartId));

    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromEmptyCart")
    public ProductDto getProductFromEmptyCart(@RequestParam("product") Product product) {
        return productMapper.mapToProductDto(cartDbService.getProductFromCart(product));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestParam("productDto") ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        cartDbService.addProductToCart(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProduct")
    public void removeProduct(@RequestParam("productDto") ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        cartDbService.removeProductFromCart(product);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestParam("orderId") int orderId) {
        return orderMapper.mapToOrderDto(cartDbService.createOrder(orderId));
    }


}
