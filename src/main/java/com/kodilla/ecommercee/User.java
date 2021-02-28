package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERID", unique = true)
    private int userId;
    @Column(name = "USERNAME")
    private String userName;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "KEY")
    private String tokenUserKey;
    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "carts",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Cart cart;
}
