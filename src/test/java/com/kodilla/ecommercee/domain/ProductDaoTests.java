package com.kodilla.ecommercee.domain;



import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDao;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTests {

    @Autowired
    private ProductDao productDao ;

    @Autowired
    private GroupDao groupDao ;

    @Autowired
    private CartDao cartDao ;

    @Autowired
    private OrderDao orderDao ;

    @Autowired
    private UserDao userDao ;

    @Test
    public void testProductDaoSave() {
        //Given
        Product product = new Product("produkt testowy","opis produktu testowego",2.20);

        //When
        productDao.save(product);

        //Then
        List<Product> readProduct = productDao.findAll();
        assertEquals(1, readProduct.size());

        //CleanUp
        productDao.deleteAll();

    }

    @Test
    public void testProductDaoFindProductByName() {
        //Given
        Product product = new Product("produkt testowy","opis produktu testowego",2.20);

        //When
        productDao.save(product);

        //Then
        Product readProduct = productDao.findByProductName(product.getProductName());
        assertEquals(product.getProductId(), readProduct.getProductId());

        //CleanUp
        productDao.deleteAll();

    }

    @Test
    public void testGetProductGroup() {
        //Given
        Group group = new Group();
        Product product = new Product("produkt testowy","opis produktu testowego",2.20);
        String groupName = "testGroup";
        group.setName(groupName);
        product.setGroup(group);

        //When
        groupDao.save(group);
        productDao.save(product);

        //Then
        Product readProduct = productDao.findByProductName(product.getProductName());
        assertEquals(product.getGroup().getGroupId(), readProduct.getGroup().getGroupId());

        //CleanUp
        productDao.deleteAll();

    }

    @Test
    public void testGetProductCart() {
        //Given
        Product product = new Product("produkt testowy","opis produktu testowego",2.20);
        Cart cart = new Cart();
        Order order = new Order();
        User user = new User();
        Group group = new Group();

        List<Order> orders = new LinkedList<>();
        List<Cart> carts = new LinkedList<>();
        product.setCarts(carts);
        product.setOrders(orders);

        carts.add(cart);
        user.setCarts(carts);
        order.setCart(cart);

        cart.setUser(user);
        cart.setOrder(order);







        //When
        orderDao.save(order);
        cartDao.save(cart);

        productDao.save(product);
        userDao.save(user);


        //Then
        Product readProduct = productDao.findByProductName(product.getProductName());
        assertEquals(product.getCarts().get(0).getCartId(), readProduct.getCarts().get(0).getCartId());

        //CleanUp
        productDao.deleteAll();

    }


}
