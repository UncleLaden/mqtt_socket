package cn.zrb.entity;

/**
 * Created by admin on 2017/2/21.
 */
public class UserDevice {
    private long id;
    private int userId;
    private int deviceId;

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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "id=" + id +
                ", userId=" + userId +
                ", deviceId=" + deviceId +
                '}';
    }
}
