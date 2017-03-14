package cn.zrb.dao.impl;

import cn.zrb.dao.UserDaoInter;
import cn.zrb.entity.Device;
import cn.zrb.entity.User;
import cn.zrb.entity.UserDevice;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/2/21.
 */
public class UserDaoImpl implements UserDaoInter {

    @Resource
    SessionFactory sessionFactory;
    public void addUser(User user){

        sessionFactory.getCurrentSession().save(user);
    }

    public void addDevice(Device device) {
        sessionFactory.getCurrentSession().save(device);
    }
    public List<Device> findAllDevice(int id) {
        return (List<Device>)sessionFactory.getCurrentSession().createQuery(
                "FROM Device where userId=? and exitFlag=?").setParameter(0,id).setParameter(1,true).list();
    }

    public void saveUserDevice(UserDevice userDevice){
        sessionFactory.getCurrentSession().save(userDevice);
    }


    public User findByUserName(String name) {
        return (User)sessionFactory.getCurrentSession().createQuery("from User where userName=?")
                .setParameter(0,name).uniqueResult();
    }

    public User findUser(String name, String pwd){
        return (User)sessionFactory.getCurrentSession().createQuery("from User where userName=? and passWord=?")
                            .setParameter(0,name).setParameter(1,pwd).uniqueResult();
    }

    public void delDeviceById(int deviceId) {
        sessionFactory.getCurrentSession().createQuery("update Device set exitFlag=? where id=?")
                            .setParameter(0,false).setParameter(1,deviceId).executeUpdate();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
