package com.phissy.expensetracker.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6,message = "Password must be at least 6 characters")
    private String password;

    private Long age = 0L;

}
