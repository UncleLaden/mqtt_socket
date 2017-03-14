package cn.zrb.entity;

/**
 * Created by admin on 2017/2/21.
 */
public class Topic {
    private long id;
    private int userId;
    private String topic;
    private int deviceId;
    private Boolean direct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getDirect() {
        return direct;
    }

    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", userId=" + userId +
                ", topic='" + topic + '\'' +
                ", deviceId=" + deviceId +
                ", direct=" + direct +
                '}';
    }
}
