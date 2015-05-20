package com.springapp.mvc.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Айрат on 19.04.2015.
 */
public class SignUp {
    @Size(min=3, max=20)
    @NotNull
    private String name;

    @Size(min=3, max=20)
    @NotNull
    private String surname;

    @Email
    @NotEmpty
    private String email;

    @Size(min = 6, max = 20)
    @NotNull
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
