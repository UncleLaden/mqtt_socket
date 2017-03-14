package cn.zrb.entity;

import java.util.Date;

/**
 * Created by admin on 2017/2/21.
 */
public class Message {
    private long id;
    private long topicId;
    private String message;
    private Date subTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public Date getSubTime() {
        return subTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", message='" + message + '\'' +
                ", subTime=" + subTime +
                '}';
    }
}
