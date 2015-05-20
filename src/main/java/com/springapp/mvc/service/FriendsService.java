package com.springapp.mvc.service;

import com.springapp.mvc.domain.Friends;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 12.05.2015.
 */
@Service
public class FriendsService {

    @Autowired
    public SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Friends> getAllFriends(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Friends.class)
                .add(Restrictions.eq("friend_from_user_id.id", id)).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Friends> getRequests(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Friends.class)
                .add(Restrictions.and(
                        Restrictions.eq("friend_for_user_id.id", id),
                        Restrictions.eq("viewed", false))).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void add(Friends friends) {
        sessionFactory.getCurrentSession().save(friends);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void update(Friends friends) {
        sessionFactory.getCurrentSession().update(friends);
    }
}
