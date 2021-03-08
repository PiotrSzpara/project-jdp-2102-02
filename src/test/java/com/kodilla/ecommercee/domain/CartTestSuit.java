package com.kodilla.ecommercee.domain;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuit {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;


   @Test
    public void testCreateNewCart() {
        //Given
        Cart cart = new Cart();

        //When
        cartDao.save(cart);

        //Then
        int id = cart.getCartId();
        Optional<Cart> readCart = cartDao.findById(id);
        assertTrue(readCart.isPresent());

        //CleanUp
        cartDao.deleteById(id);
    }

    @Test
    public void testCartAndOrderRelations() {
       //Given
        Cart cart = new Cart();
        Order order = new Order();

        order.setOrderName("02/04/21");
        order.setOrderDate(Date.from(Instant.now()));
        order.setCart(cart);
        orderDao.save(order);
        cart.setOrder(order);

        //When
        cartDao.save(cart);
        int cartId = cart.getCartId();
        orderDao.save(order);
        int cartIdInOrder = order.getCart().getCartId();


        int orderId = order.getOrderId();
        int orderIdInCart = cart.getOrder().getOrderId();

        //Then
        assertEquals(cartId, cartIdInOrder);
        assertEquals(orderId, orderIdInCart);

        //CleanUp
        cartDao.deleteById(cartId);
        orderDao.deleteById(orderId);

    }
    @Test
    public void testCartAndUserRelations() {
       //Given
       List<Cart> carts = new ArrayList<>();

       Cart cart1 = new Cart();
       carts.add(cart1);

       User user = new User();

       user.setUserName("Adam");
       user.setEmail("adam@gmail.com");
       user.setCarts(carts);
       userDao.save(user);
       cart1.setUser(user);

       //When
       cartDao.save(cart1);
       int cart1Id = cart1.getCartId();

       int userId = user.getUserId();
       int cart1UserId = cart1.getUser().getUserId();

       //Then
       assertSame(cart1UserId, userId);

       //CleanUp
       cartDao.deleteById(cart1Id);
       userDao.deleteById(userId);

   }

    @Test
    public void testCartAndProductRelations() {
        //Given
        List<Product> products = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Cart cart1 = new Cart();
        carts.add(cart1);

        Product product1 = new Product();

        product1.setProductName("apple");
        product1.setProductPrice(2.76);
        product1.setProductDescription("green");
        products.add(product1);

        product1.setCarts(carts);
        productDao.save(product1);
        cart1.setProducts(products);

        //When
        cartDao.save(cart1);
        int cart1Id = cart1.getCartId();
        int product1Id = product1.getProductId();

        String productName = product1.getProductName();
        String productNameInCart = cart1.getProducts().get(products.size()-1).getProductName();

        //Then
        assertEquals(productName, productNameInCart);

        //CleanUp
        cartDao.deleteById(cart1Id);
        productDao.deleteAll();

    }

    @Test
    public void testDeleteCart() {
        //Given
        List<Product> products = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Cart cart1 = new Cart();
        carts.add(cart1);

        Product product1 = new Product();

        product1.setProductName("apple");
        product1.setProductPrice(2.76);
        product1.setProductDescription("green");
        products.add(product1);

        product1.setCarts(carts);
        productDao.save(product1);
        cart1.setProducts(products);

        //When
        cartDao.save(cart1);
        int cart1Id = cart1.getCartId();
        int product1Id = product1.getProductId();


        //Then
        assertTrue(carts.size() == 1);
        assertTrue(cartDao.existsById(cart1Id));

        //CleanUp
        cartDao.deleteById(cart1Id);
        assertFalse(cartDao.existsById(cart1Id));
        assertFalse(productDao.existsById(product1Id));
        productDao.deleteAll();

    }
}
