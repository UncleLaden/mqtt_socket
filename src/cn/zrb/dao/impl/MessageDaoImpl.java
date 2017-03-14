package cn.zrb.dao.impl;

import cn.zrb.dao.MessageDaoInter;
import cn.zrb.entity.Message;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/2/22.
 */
public class MessageDaoImpl implements MessageDaoInter {

    @Resource
    SessionFactory sessionFactory;

    public void insertMsg(Message msg) {
        sessionFactory.getCurrentSession().save(msg);
    }

    public Message findByTopic(long topicId){
        return (Message)sessionFactory.getCurrentSession().createQuery("from Message where topicId=? order by subTime")
                            .setParameter(0, topicId).list().get(0);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
