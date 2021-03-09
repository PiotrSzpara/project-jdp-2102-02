package com.kodilla.ecommercee.domain;



import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
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
        Product product = new Product("produkt testowy1","opis produktu testowego",2.20);

        //When
        productDao.save(product);

        //Then
        List<Product> readProduct = productDao.findAll();
        assertEquals(1, readProduct.size());

        //CleanUp
        productDao.deleteAll();

    }

    @Test
    public void testProductDaoDelete() {
        //Given
        Product product = new Product("produkt testowy1","opis produktu testowego",2.20);

        //When
        productDao.save(product);
        productDao.deleteById(product.getProductId());
        //Then
        List<Product> readProduct = productDao.findAll();
        assertEquals(0, readProduct.size());

        //CleanUp
        productDao.deleteAll();

    }

    @Test
    public void testRelationsAfterDelete() {
        //Given
        Product product = new Product("produkt testowy3","opis produktu testowego",2.20);
        Cart cart = new Cart();
        Order order = new Order();
        User user = new User();

        List<Order> orders = new LinkedList<>();
        List<Cart> carts = new LinkedList<>();
        List<Product> products = new LinkedList<>();


        user.setPassword("strongPassword");
        user.setEmail("email");
        user.setTokenUserKey("token");

        user.setCarts(carts);
        order.setCart(cart);
        cart.setOrder(order);
        cart.setUser(user);
        orders.add(order);
        product.setOrders(orders);

        products.add(product);
        cart.setProducts(products);
        carts.add(cart);
        product.setCarts(carts);

        //When
        productDao.save(product);
        userDao.save(user);
        cartDao.save(cart);
        orderDao.save(order);

        productDao.deleteById(product.getProductId());

        //Then
        Cart  readCart = cartDao.findById(cart.getCartId());
        assertSame(readCart.getCartId(), cart.getCartId());

        User readUser = userDao.findById(user.getUserId());
        assertSame(readUser.getUserId(),user.getUserId());

        Order readOrder = orderDao.findById(order.getOrderId());
        assertSame(readOrder.getOrderId(),order.getOrderId());

        //CleanUp

        userDao.deleteAll();
        orderDao.deleteAll();
        cartDao.deleteAll();


    }


    @Test
    public void testProductAndGroupRelations() {
        //Given
        Group group = new Group();
        Product product = new Product("produkt testowy2","opis produktu testowego",2.20);
        String groupName = "testGroup";
        group.setName(groupName);
        product.setGroup(group);

        //When
        productDao.save(product);
        groupDao.save(group);


        //Then
        Product readProduct = productDao.findByProductName(product.getProductName());
        assertEquals(product.getGroup().getGroupId(), readProduct.getGroup().getGroupId());

        //CleanUp
        productDao.deleteAll();
        groupDao.deleteAll();

    }

    @Test
    public void testProductAndCartRelations() {
        //Given
        Product product = new Product("produkt testowy3","opis produktu testowego",2.20);
        Cart cart = new Cart();
        Order order = new Order();
        User user = new User();

        List<Order> orders = new LinkedList<>();
        List<Cart> carts = new LinkedList<>();
        List<Product> products = new LinkedList<>();


        user.setPassword("strongPassword");
        user.setEmail("email");
        user.setTokenUserKey("token");

        user.setCarts(carts);
        order.setCart(cart);
        cart.setOrder(order);
        cart.setUser(user);
        orders.add(order);
        product.setOrders(orders);

        products.add(product);
        cart.setProducts(products);
        carts.add(cart);
        product.setCarts(carts);

        //When
        productDao.save(product);
        userDao.save(user);
        cartDao.save(cart);
        orderDao.save(order);

        int readCartId = product.getCarts().get(0).getCartId();
        int cartId = cart.getCartId();
        //Then
        assertSame(cartId,readCartId);

        //CleanUp

        userDao.deleteAll();
        orderDao.deleteAll();
        cartDao.deleteAll();
        productDao.deleteAll();

    }



}