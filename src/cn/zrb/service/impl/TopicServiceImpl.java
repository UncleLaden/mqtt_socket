package cn.zrb.service.impl;

import cn.zrb.dao.TopicDaoInter;
import cn.zrb.entity.Topic;
import cn.zrb.service.TopicServiceInter;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/2/22.
 */
@Transactional
public class TopicServiceImpl implements TopicServiceInter {

    @Resource
    TopicDaoInter topicDao;
    public void insert(Topic topic){
        topicDao.insert(topic);
    }
    public Topic findByUidAndDidAndDir(int uid, int did,boolean dir){
        return topicDao.findByUidAndDidAndDir(uid, did, dir);
    }
    public Topic findByTopic(String tp) {
        return topicDao.findByTopic(tp);
    }

    public TopicDaoInter getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDaoInter topicDao) {
        this.topicDao = topicDao;
    }
}
