package com.kodilla.ecommercee;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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
    @OneToMany(targetEntity = Cart.class,
            mappedBy = "cartId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Cart> carts;
}
