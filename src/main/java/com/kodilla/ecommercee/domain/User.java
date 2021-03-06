package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USERS")
@Builder
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERID", unique = true)
    private int userId;
    @Column(name = "USERNAME")
    private String userName;
    //@NotNull
    @Column(name = "EMAIL")
    private String email;
    //@NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "KEY_VALUE")
    private String tokenUserKey;
    @OneToMany(targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Cart> carts;
}