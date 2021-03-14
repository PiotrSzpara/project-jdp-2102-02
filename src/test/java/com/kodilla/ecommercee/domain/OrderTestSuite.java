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
    @Autowired
    private ProductDao productDao;

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
    public void testOrderAndProductRelations(){
        //Given
        Order order = new Order();
        order.setOrderName("Food");
        order.setPaid(true);
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setProductName("Apple");
        product2.setProductName("Banana");
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        product1.getOrders().add(order);
        product2.getOrders().add(order);

        //When
        orderDao.save(order);
        productDao.save(product1);
        productDao.save(product2);

        int orderId = order.getOrderId();
        int orderProduct1Id = order.getProducts().get(order.getProducts().indexOf(product1)).getProductId();
        int orderProduct2Id = order.getProducts().get(order.getProducts().indexOf(product2)).getProductId();

        int product1Id = product1.getProductId();
        int product2Id = product2.getProductId();

        int product1OrderId = product1.getOrders().get(product1.getOrders().indexOf(order)).getOrderId();
        int product2OrderId = product2.getOrders().get(product2.getOrders().indexOf(order)).getOrderId();

        //Then
        assertEquals(orderId, product1OrderId);
        assertEquals(orderId, product2OrderId);
        assertEquals(product1Id, orderProduct1Id);
        assertEquals(product2Id, orderProduct2Id);

        //CleanUp
        productDao.deleteById(product1Id);
        productDao.deleteById(product2Id);
        orderDao.deleteById(orderId);
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
