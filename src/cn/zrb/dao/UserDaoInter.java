package cn.zrb.dao;

import cn.zrb.entity.Device;
import cn.zrb.entity.User;
import cn.zrb.entity.UserDevice;

import java.util.List;

/**
 * Created by admin on 2017/2/21.
 */
public interface UserDaoInter {
    public void addUser(User user);
    public void addDevice(Device device);
    public void saveUserDevice(UserDevice userDevice);
    public List<Device> findAllDevice(int id);

    public User findByUserName(String name);
    public User findUser(String name, String pwd);

    public void delDeviceById(int deviceId);

}
