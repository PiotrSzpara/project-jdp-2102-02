package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupDbService {

    private final GroupDao groupDao;

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }

    public Group getGroup(final int id) {
        return groupDao.findById(id);
    }

    public Group saveGroup(final Group group) {
        return groupDao.save(group);
    }

    public void deleteGroup(final Integer id) {
        groupDao.deleteById(id);
    }
}
