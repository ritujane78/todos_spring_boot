package com.jane.springboot.todos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AuthenticationRequest {
    @NotEmpty(message = "Email is mandatory.")
    @Email(message = "Email is of incorrect format.")
    private String email;

    @NotEmpty(message = "Password is mandatory.")
    @Size(min = 5, max = 30, message = "Password must be at least 5 characters long.")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
