package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private final CartDbService cartDbService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @Autowired
    public CartController(CartDbService cartDbService, CartMapper cartMapper, ProductMapper productMapper) {
        this.cartDbService = cartDbService;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto newCart(@RequestParam("userId") int userId) {
        return cartMapper.mapToCartDto(cartDbService.createCart(userId));

    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam("cart") Cart cart) {
        return productMapper.mapToProductDtoList(cartDbService.getProductsFromCart(cart));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProductFromCart(@RequestParam("cart") CartDto cartDto, @RequestParam("productDto") ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Cart cart = cartMapper.mapToCart(cartDto);
        cartDbService.addProductToCart(cart, product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProduct")
    public void removeProduct(@RequestParam("cart") CartDto cartDto, @RequestParam("productDto") ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Cart cart = cartMapper.mapToCart(cartDto);
        cartDbService.deleteProductFromCart(cart, product);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestParam("cart") CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
         cartDbService.createOrder(cart);
    }


}
