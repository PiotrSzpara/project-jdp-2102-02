package com.kodilla.ecommercee.domain;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor
public class OrderTestSuite {
    private final OrderDao orderDao;
    private final CartDao cartDao;

    @Test
    public void testOrderCreate(){
        //Given
        Order order = new Order();
        order.setOrderName("Food");
        order.setPaid(true);

        //When
        orderDao.save(order);
        int orderId = order.getOrderId();
        Order readOrder = orderDao.findById(orderId);

        //Then
        assertEquals(orderId, readOrder.getOrderId());

        //CleanUp
        orderDao.deleteById(orderId);
    }

    @Test
    public void testOrderDelete(){
        //Given
        Order order = new Order();
        order.setOrderName("Food");
        order.setPaid(true);

        //When
        orderDao.save(order);
        int orderId = order.getOrderId();
        orderDao.deleteById(orderId);

        Optional<Order> recordOrder = orderDao.findById(orderId);

        //Then
        assertFalse(recordOrder.isPresent());
    }

    @Test
    public void testOrderAndCartRelations(){
        //Given
        Order order = new Order();
        order.setOrderName("Food");
        order.setPaid(true);
        Cart cart = new Cart();
        cart.setOrder(order);
        order.setCart(cart);

        //When
        cartDao.save(cart);
        orderDao.save(order);

        int orderId = order.getOrderId();
        int cartId = cart.getCartId();
        int cartOrderId = cartDao.findById(cartId).getOrder().getOrderId();
        int orderCartId = orderDao.findById(orderId).getCart().getCartId();

        //Then
        assertEquals(orderId, cartOrderId);
        assertEquals(cartId, orderCartId);

        //CleanUp
        orderDao.deleteById(orderId);
        cartDao.deleteById(cartId);
    }

    @Test
    public void testOrderUpdate(){
        //Given
        Order order = new Order();
        order.setOrderName("Animals");
        order.setPaid(false);

        //When
        orderDao.save(order);
        int beforeOrderId = order.getOrderId();
        Order readOrderBefore = orderDao.findById(beforeOrderId);

        order.setPaid(true);
        orderDao.save(order);
        int afterOrderId = order.getOrderId();
        Order readOrderAfter = orderDao.findById(afterOrderId);

        //Then
        assertEquals(beforeOrderId, readOrderBefore.getOrderId());
        assertEquals(afterOrderId, readOrderAfter.getOrderId());

        //CleanUp
        orderDao.deleteById(afterOrderId);
    }
}
