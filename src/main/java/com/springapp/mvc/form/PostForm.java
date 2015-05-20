package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Айрат on 15.05.2015.
 */
public class PostForm {

    @NotBlank
    private String text;

    public PostForm() {
    }

    public PostForm(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
