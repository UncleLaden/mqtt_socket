package cn.zrb.service;

import cn.zrb.entity.Topic;

/**
 * Created by admin on 2017/2/22.
 */
public interface TopicServiceInter {
    public void insert(Topic topic);
    public Topic findByUidAndDidAndDir(int uid, int did,boolean dir);
    public Topic findByTopic(String tp);
}
