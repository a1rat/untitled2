package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Date;

/**
* Created by Айрат on 08.04.2015.
*/
@Entity
@Table(name = "Posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

    @Column(nullable = false)
    private Date date;

    @Column(length = 15895)
    private String text;

    @Column
    private String content;

    public Posts() {
    }

    public Posts(UserInfo user, Date date, String text, String content) {
        this.user = user;
        this.date = date;
        this.text = text;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
