package cn.zrb.web.action;

import cn.zrb.entity.Message;
import cn.zrb.entity.Topic;
import cn.zrb.service.MessageServiceInter;
import cn.zrb.service.TopicServiceInter;

import javax.annotation.Resource;
import java.util.Date;

public class PublishAction extends DefaultAction{

    public String topic;
    public String msg;
    @Resource
    TopicServiceInter topicService;
    @Resource
    MessageServiceInter messageService;

    public String pub() {

        Topic tp = topicService.findByTopic(topic);
        Message message = new Message();
        message.setTopicId(tp.getId());
        message.setMessage(msg);
        message.setSubTime(new Date());
        messageService.insertMsg(message);
        return NONE;
    }


    public TopicServiceInter getTopicService() {
        return topicService;
    }

    public void setTopicService(TopicServiceInter topicService) {
        this.topicService = topicService;
    }

    public MessageServiceInter getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageServiceInter messageService) {
        this.messageService = messageService;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
