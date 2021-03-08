package com.kodilla.ecommercee.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTest {
    @Autowired
    private GroupDao groupDao ;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testGroupsDaoGet() {

    }

    @Test
    public void testGroupDaoCreate() {
        //Given
        Group group = new Group();
        group.setName("Alkohole");

        //When
        groupDao.save(group);
        Optional<Group> readGroup = groupDao.findById(group.getGroupId());

        //Then
        Assert.assertTrue(readGroup.isPresent());

        //CleanUp
        groupDao.deleteById(group.getGroupId());
    }

    @Test
    public void testGroupDaoDescriptionLenght() {
        //Given
        Group group = new Group();
        group.setName("not null");
        group.setDescription("this is very long description to test lenght adnotation for fun and for learning programming to get good paid job at end");

        //When
        groupDao.save(group);
        Optional<Group> getGroup = groupDao.findById(group.getGroupId());

        //Then
        Assert.assertFalse(getGroup.isPresent());
        while(group.getDescription().length() < 45) {
            try { Assert.assertTrue(getGroup.isPresent());}
            catch (Exception e){
                System.out.println("Description nie może mieć więcej niż 45 znaków długości");
            }
        //CleanUp
        groupDao.deleteById(group.getGroupId());
    }}

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
