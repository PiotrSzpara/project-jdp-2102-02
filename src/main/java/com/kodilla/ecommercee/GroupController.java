package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/group")
public class GroupController {

    public GroupController() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups(){
        List<GroupDto> groups = new ArrayList<>();
        groups.add(new GroupDto(0, "food", "tasty food"));
        groups.add(new GroupDto(1, "electronics", "technology of future"));
        return groups;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto createGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(groupDto.getGroupId(), groupDto.getName(), groupDto.getDescription());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam int groupId){
        return new GroupDto(groupId ,"food", "tasty food");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(groupDto.getGroupId(), groupDto.getName(), groupDto.getDescription());
    }
}
