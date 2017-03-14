package cn.zrb.dao;

import cn.zrb.entity.Message;

/**
 * Created by admin on 2017/2/22.
 */
public interface MessageDaoInter {
    public void insertMsg(Message msg);
    public Message findByTopic(long topicId);
}
