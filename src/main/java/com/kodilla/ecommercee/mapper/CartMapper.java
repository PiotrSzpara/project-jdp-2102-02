package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        Cart cart = new Cart();
        cart.setCartId(cartDto.getCartId());
        return cart;
    }

    public CartDto mapToCartDto(final Cart cart) {
        CartDto cartDto = new CartDto(cart.getCartId());

        return cartDto;
    }

    public List<CartDto> maptoTaskDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
