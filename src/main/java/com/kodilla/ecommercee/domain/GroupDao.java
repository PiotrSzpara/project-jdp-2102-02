package com.kodilla.ecommercee.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GroupDao extends CrudRepository<Group, Integer> {

    @Override
    List<Group> findAll();

    Group findById(int id);

    @Override
    Group save(Group group);

    @Override
    void deleteById(Integer id);
}