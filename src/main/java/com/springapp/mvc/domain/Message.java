package com.springapp.mvc.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
* Created by Айрат on 08.04.2015.
*/
@Entity
@Table(name = "Message")
@Proxy(lazy=false)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id")
    private UserInfo from_user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    private UserInfo to_user_id;

    @Column
    private Date date;

    @Column(length = 4096, nullable = false)
    private String text;

    @Column()
    private Boolean viewed;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public Message(UserInfo from_user_id, UserInfo to_user_id, Date date, String text, boolean viewed) {
        this.from_user_id = from_user_id;
        this.to_user_id = to_user_id;
        this.date = date;
        this.text = text;
        this.viewed = viewed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(UserInfo from_user_id) {
        this.from_user_id = from_user_id;
    }

    public UserInfo getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(UserInfo to_user_id) {
        this.to_user_id = to_user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }
}
