package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {

    @Autowired
    private GroupDao groupDao;

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }

    public Optional<Group> getGroup(final int id) {
        return groupDao.findById(id);
    }

    public Group saveGroup(final Group group) {
        return groupDao.save(group);
    }

    public void deleteGroup(final int id) {
        groupDao.deleteById(id);
    }
}
