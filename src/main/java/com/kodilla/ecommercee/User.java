package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERID", unique = true)
    private int userId;
    @Column(name = "USERNAME")
    private String firstName;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "KEY")
    private String tokenUserKey;
//    private boolean status;
//    @OneToMany
//    private Cart cart;
}
