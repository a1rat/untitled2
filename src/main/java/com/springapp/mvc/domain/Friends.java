package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Айрат on 12.05.2015.
 */
@Entity
@Table(name = "Friends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_from_id")
    private UserInfo friend_from_user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_for_id")
    private UserInfo friend_for_user_id;

    @Column
    private Boolean viewed;

    public Friends() {
    }

    public Friends(UserInfo friend_from_user_id, UserInfo friend_for_user_id, Boolean viewed) {
        this.friend_from_user_id = friend_from_user_id;
        this.friend_for_user_id = friend_for_user_id;
        this.viewed = viewed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getFriend_from_user_id() {
        return friend_from_user_id;
    }

    public void setFriend_from_user_id(UserInfo friend_from_user_id) {
        this.friend_from_user_id = friend_from_user_id;
    }

    public UserInfo getFriend_for_user_id() {
        return friend_for_user_id;
    }

    public void setFriend_for_user_id(UserInfo friend_for_user_id) {
        this.friend_for_user_id = friend_for_user_id;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }
}
