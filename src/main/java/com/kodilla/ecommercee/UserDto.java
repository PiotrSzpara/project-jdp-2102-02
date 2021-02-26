package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userId;
    @NotBlank (message = "FirstName cannot be blank")
    private String firstName;
    @NotBlank
    private String email;
    @NotBlank
    @Length(min = 6, max = 16)
    private String password;
    private int tokenUserKey;
    private boolean status;
}
