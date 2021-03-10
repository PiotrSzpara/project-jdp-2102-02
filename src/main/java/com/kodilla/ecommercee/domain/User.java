package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private String tokenUserKey;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERID", unique = true)
    public int getUserId() {
        return userId;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    //@NotNull
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    //@NotNull
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "KEY_VALUE")
    public String getTokenUserKey() {
        return tokenUserKey;
    }

    @OneToMany(targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Cart> getCarts() {
        return carts;
    }

}
