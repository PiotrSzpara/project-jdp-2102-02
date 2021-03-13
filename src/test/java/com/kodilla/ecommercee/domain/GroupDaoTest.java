package com.kodilla.ecommercee.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTest {
    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testGroupsDao() {
        //Given
        Group group = new Group();
        group.setName("not null");
        Product product = new Product();
        Product product2 = new Product();
        group.getProducts().add(product);
        group.getProducts().add(product2);

        //When
        groupDao.save(group);
        int groupId = group.getGroupId();
        int productId = product.getProductId();
        int product2Id = product2.getProductId();

        Group readGroup = groupDao.findById(groupId);

        //Then
        assertEquals(groupId, readGroup.getGroupId());
        Assert.assertEquals(productId, product.getProductId());
        Assert.assertEquals(product2Id, product2.getProductId());

        //CleanUp
        groupDao.deleteById(groupId);
    }

    @Test
    public void testGroupDaoCreate() {
        //Given
        Group group = new Group();
        group.setName("Alkohole");

        //When
        groupDao.save(group);
        Group readGroup = groupDao.findById(group.getGroupId());
        int groupId = group.getGroupId();

        //Then
        assertEquals(groupId, readGroup.getGroupId());

        //CleanUp
        groupDao.deleteById(group.getGroupId());
    }

    @Test
    public void testGroupDaoDelete() {
        //Given
        Group group = new Group();
        group.setName("not null");
        group.setDescription("this is short description to check lenght");
        Product product = new Product();
        group.getProducts().add(product);
        product.setGroup(group);

        //When
        groupDao.save(group);
        int groupId = group.getGroupId();
        int productId = product.getProductId();
        groupDao.deleteById(groupId);


        //Then
        assertFalse(groupDao.existsById(groupId));
        Assert.assertEquals(productId, product.getProductId());
    }

    @Test
    public void testGroupDaoUpdate() {
        //Given
        Group group = new Group();
        group.setName("Alkohole");

        //When
        groupDao.save(group);
        int groupId = group.getGroupId();

        //ThenTest
        assertEquals("Alkohole", group.getName());

        //Update
        group.setName("Hamburgery");

        //Then
        assertEquals("Hamburgery", group.getName());

        //CleanUp
        groupDao.deleteById(groupId);
    }

}
