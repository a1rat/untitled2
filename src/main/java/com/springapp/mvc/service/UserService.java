package com.springapp.mvc.service;

import com.springapp.mvc.domain.UserInfo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
* Created by Айрат on 06.04.2015.
*/
@Service
public class UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(UserInfo userInfo) {
        sessionFactory.getCurrentSession().save(userInfo);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<UserInfo> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserInfo.class).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public UserInfo getById(Long id) {
        return (UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public UserInfo getIdByEmail(String email) {
        return (UserInfo) sessionFactory.getCurrentSession().createCriteria(UserInfo.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public UserInfo login(String email, String password) {
        return (UserInfo) sessionFactory.getCurrentSession().createCriteria(UserInfo.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password)).uniqueResult();
    }
}
