package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Айрат on 18.04.2015.
 */
@Entity
@Table(name = "Content")
public class Content {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "con_id")
    private UserInfo con_user_id;

    @Column(name = "link")
    private String link;

    @Column(name = "constraints")
    private Integer constraints;

    public Content() {
    }

    public Content(UserInfo con_user_id, String link) {
        this.con_user_id = con_user_id;
        this.link = link;
    }

    public Content(UserInfo con_user_id, String link, Integer constraints) {
        this.con_user_id = con_user_id;
        this.link = link;
        this.constraints = constraints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getCon_user() {
        return con_user_id;
    }

    public void setCon_user(UserInfo con_user) {
        this.con_user_id = con_user_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getConstraint() {
        return constraints;
    }

    public void setConstraint(Integer constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        return "Cont{" +
                "id=" + id +
                ", con_user=" + con_user_id +
                ", link='" + link + '\'' +
                ", constraint=" + constraints +
                '}';
    }
}
