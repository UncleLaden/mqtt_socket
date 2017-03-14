package cn.zrb.dao.impl;

import cn.zrb.dao.TopicDaoInter;
import cn.zrb.entity.Topic;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/2/21.
 */
public class TopicDaoImpl implements TopicDaoInter {

    @Resource
    SessionFactory sessionFactory;
    public void insert(Topic topic) {
        sessionFactory.getCurrentSession().save(topic);
    }
    public Topic findByUidAndDidAndDir(int uid, int did,boolean dir){
        return (Topic)sessionFactory.getCurrentSession().createQuery("from Topic where userId=? and deviceId=? and direct=?")
                            .setParameter(0, uid).setParameter(1, did).setParameter(2, dir).uniqueResult();
    }
    public Topic findByTopic(String tp){
        return (Topic) sessionFactory.getCurrentSession().createQuery("from Topic where topic=?")
                            .setParameter(0,tp).uniqueResult();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
