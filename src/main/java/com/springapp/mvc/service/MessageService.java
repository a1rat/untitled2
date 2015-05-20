package com.springapp.mvc.service;

import com.springapp.mvc.domain.Message;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 23.04.2015.
 */
@Service
public class MessageService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public void add(Message message) {

        sessionFactory.getCurrentSession().save(message);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Message> getMessagesForMe(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Message.class)
                .add(Restrictions.eq("to_user_id.id", id)).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Message> getMessagesFromMe(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Message.class)
                .add(Restrictions.eq("from_user_id.id", id)).list();
    }

//    @Transactional
//    @SuppressWarnings("unchecked")
//    public void add(Message message) {
//        if(sessionFactory.getCurrentSession().createCriteria(Dialogs.class)
//                .add(Restrictions.and(
//                        Restrictions.and(Restrictions.eq("from_id", message.getFrom_user_id().getId())),
//                        Restrictions.and(Restrictions.eq("to_id", message.getTo_user_id().getId())))) == null){
//            sessionFactory.getCurrentSession().save(new Dialogs(message.getFrom_user_id().getId(),
//                    message.getTo_user_id().getId()));
//            sessionFactory.getCurrentSession().save(new Dialogs(message.getTo_user_id().getId(),
//                    message.getFrom_user_id().getId()));
//        }
//        sessionFactory.getCurrentSession().save(message);
//    }
//
//    @Transactional
//    @SuppressWarnings("unchecked")
//    public List<Message> getListDialog(Long id) {
//        return sessionFactory.getCurrentSession().createCriteria(Message.class)
//                .add(Restrictions.or(
//                        Restrictions.and(Restrictions.eq("from_user_id.id", id)),
//                        Restrictions.and(Restrictions.eq("to_user_id.id", id)))).addOrder(Order.asc("date"))
//                .list();
//    }
//
//
//    /**
//     * все сообщения одного пользователя со мной
//     * @param idMy
//     * @param idHis
//     * @return
//     */
//    @Transactional
//    @SuppressWarnings("unchecked")
//    public List<Message> getDialogById (Long idMy, Long idHis){
//        return sessionFactory.getCurrentSession().createCriteria(Message.class)
//                .add(Restrictions.or(
//                        Restrictions.and(Restrictions.eq("from_user_id.id", idMy),
//                                Restrictions.eq("to_user_id.id", idHis)),
//                        Restrictions.and(Restrictions.eq("from_user_id.id", idHis),
//                                Restrictions.eq("to_user_id.id", idMy))
//
//                )).list();
//    }
//
//    @Transactional
//    @SuppressWarnings("unchecked")
//    public Message getMessageById(Long id) {
//        return (Message) sessionFactory.getCurrentSession().load(Message.class, id);
//    }
}
