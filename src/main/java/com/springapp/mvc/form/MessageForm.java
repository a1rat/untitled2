package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Айрат on 09.05.2015.
 */
public class MessageForm {

//    private Long to_user_id;
    @NotBlank
    private String text;

    public MessageForm() {
    }

    public MessageForm( String text) {
//        this.to_user_id = to_user_id;
        this.text = text;
    }

//    public Long getTo_user_id() {
//        return to_user_id;
//    }
//
//    public void setTo_user_id(Long to_user_id) {
//        this.to_user_id = to_user_id;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
