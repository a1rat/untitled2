package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Айрат on 22.04.2015.
 */
public class Login {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public Login() {
    }

    public Login(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
