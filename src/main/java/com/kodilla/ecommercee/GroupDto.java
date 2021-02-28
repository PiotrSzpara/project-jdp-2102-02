package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupDto {
    private int groupId;
    private String name;
    private String description;
}
