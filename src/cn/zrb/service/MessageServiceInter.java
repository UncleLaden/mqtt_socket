package cn.zrb.service;

import cn.zrb.entity.Message;

/**
 * Created by admin on 2017/2/22.
 */
public interface MessageServiceInter {
    public void insertMsg(Message msg);
    public Message findByTopic(long topicId);
}
