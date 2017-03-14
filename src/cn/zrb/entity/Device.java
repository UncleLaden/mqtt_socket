package cn.zrb.entity;

import java.util.Date;

/**
 * Created by admin on 2017/2/21.
 */
public class Device {
    private int id;
    private String deviceName;
    private String deviceKey;
    private int userId;
    private Date createTime;
    private Boolean exitFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getExitFlag() {
        return exitFlag;
    }

    public void setExitFlag(Boolean exitFlag) {
        this.exitFlag = exitFlag;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
