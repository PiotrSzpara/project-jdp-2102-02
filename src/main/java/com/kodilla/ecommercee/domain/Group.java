package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "GROUPS")
public class Group {

    private int groupId;

    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    public int getGroupId() {
        return groupId;
    }

    @OneToMany(
        targetEntity = Product.class,
        mappedBy = "group",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
)
    public List<Product> getProducts() {
        return products;
    }
}
