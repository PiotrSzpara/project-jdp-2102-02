package com.kodilla.ecommercee.domain;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        order.setCart(cart);
        cart.setOrder(order);

        //When
        cartDao.save(cart);
        int cartId = cart.getCartId();
        int cartIdInOrder = order.getCart().getCartId();


        long orderId = order.getOrderId();
        long orderIdInCart = cart.getOrder().getOrderId();

        //Then
        assertSame(cartId, cartIdInOrder);
        assertSame(orderId, orderIdInCart);

        //CleanUp
        cartDao.deleteById(cartId);


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
        cart1.setProducts(products);

        //When
        cartDao.save(cart1);
        int cart1Id = cart1.getCartId();

        String productName = product1.getProductName();
        String productNameInCart = cart1.getProducts().get(products.size()-1).getProductName();

        //Then
        assertEquals(productName, productNameInCart);

        //CleanUp
        cartDao.deleteById(cart1Id);

    }
}
