package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GROUPS")
public class Group {

    private int groupId;
    private String name;
    private String description;
    private List<Product> products = new ArrayList<>();

    public Group(int groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    public int getGroupId() {
        return groupId;
    }

    @NotNull
    @Length(max = 45)
    @Column(name = "NAME", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(max = 45)
    @Column(name = "DESCRIPTION", length = 45)
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

}
