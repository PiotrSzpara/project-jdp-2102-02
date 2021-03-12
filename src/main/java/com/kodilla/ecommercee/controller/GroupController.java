package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupMapper groupMapper;
    private final GroupDbService groupDbService;


    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups(){
        List<Group> groups = groupDbService.getAllGroups();
        return groupMapper.mapToGroupDtoList(groups);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam int groupId){
        return groupMapper.mapToGroupDto(groupDbService.getGroup(groupId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto){
        Group group = groupMapper.mapToGroup(groupDto);
        groupDbService.saveGroup(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(groupDto.getGroupId(), groupDto.getGroupName(), groupDto.getGroupDescription());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam int id) {
        groupDbService.deleteGroup(id);
    }
}
