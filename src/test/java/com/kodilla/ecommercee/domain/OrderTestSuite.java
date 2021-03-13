package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartDao cartDao;

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

        Order recordOrder = orderDao.findById(orderId);

        //Then
        assertNull(recordOrder);
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
