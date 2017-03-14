package cn.zrb.service.impl;

import cn.zrb.dao.MessageDaoInter;
import cn.zrb.entity.Message;
import cn.zrb.service.MessageServiceInter;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by admin on 2017/2/22.
 */
@Transactional
public class MessageServiceImpl implements MessageServiceInter {

    @Resource
    MessageDaoInter messageDao;

    public void insertMsg(Message msg) {
        messageDao.insertMsg(msg);
    }

    public Message findByTopic(long topicId){
        return messageDao.findByTopic(topicId);
    }

    public MessageDaoInter getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDaoInter messageDao) {
        this.messageDao = messageDao;
    }
}
