package com.springapp.mvc.service;

import com.springapp.mvc.domain.Posts;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 13.04.2015.
 */
@Service
public class PostService {

    @Autowired
    public SessionFactory sessionFactory;

    @Autowired
    public UserService userService;

    @Transactional
    public void add(Posts posts) {
        sessionFactory.getCurrentSession().save(posts);
    }

//    @Transactional
//    @SuppressWarnings("unchecked")
//    public Posts getPostsUser(Long id) {
//        return (Posts) sessionFactory.getCurrentSession().load(Posts.class,id);
//    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Posts> getPost(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Posts.class)
                .add(Restrictions.eq("user.id", id)).addOrder(Order.desc("date")).list();
    }
}
