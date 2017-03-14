package cn.zrb.dao;

import cn.zrb.entity.Topic;

/**
 * Created by admin on 2017/2/21.
 */
public interface TopicDaoInter {

    public void insert(Topic topic);
    public Topic findByUidAndDidAndDir(int uid, int did,boolean dir);
    public Topic findByTopic(String tp);
}
