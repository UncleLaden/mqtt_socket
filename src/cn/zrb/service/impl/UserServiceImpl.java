package cn.zrb.service.impl;

import cn.zrb.dao.UserDaoInter;
import cn.zrb.entity.Device;
import cn.zrb.entity.User;
import cn.zrb.entity.UserDevice;
import cn.zrb.service.UserServiceInter;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/2/21.
 */
@Transactional
public class UserServiceImpl implements UserServiceInter {
    @Resource
    UserDaoInter userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void addDevice(Device device) {
        userDao.addDevice(device);
    }

    public void saveUserDevice(UserDevice userDevice){
        userDao.saveUserDevice(userDevice);
    }

    public List<Device> findAllDevice(int id){
        return userDao.findAllDevice(id);
    }

    public User findByUserName(String name) {return userDao.findByUserName(name);}
    public User findUser(String name, String pwd){
        return userDao.findUser(name, pwd);
    }

    public void delDeviceById(int deviceId){
        userDao.delDeviceById(deviceId);
    }

    public UserDaoInter getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoInter userDao) {
        this.userDao = userDao;
    }
}
