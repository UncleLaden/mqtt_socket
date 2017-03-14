package cn.zrb.web.action;

import cn.zrb.entity.Device;
import cn.zrb.entity.Information;
import cn.zrb.entity.Topic;
import cn.zrb.entity.User;
import cn.zrb.service.TopicServiceInter;
import cn.zrb.service.UserServiceInter;
import cn.zrb.test.UUID22;
import cn.zrb.util.JSONKit;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by admin on 2017/2/21.
 */
public class UserAction extends DefaultAction {

    public String userName;
    public String passWord;
    public String deviceName;
    public String deviceId;
    public String deviceKey;

    @Resource
    private UserServiceInter userService;
    @Resource
    private TopicServiceInter topicService;

    public String login() {

        User user = userService.findUser(userName, passWord);
        if(user == null) {
            return "toLogin";
        }
        setCurrUser(user);
        setDevice(userService.findAllDevice(user.getId()));
        return "myDevice";

    }

    public String findByUserName() {
        User user1 = userService.findByUserName(userName);
        if (user1 !=null) {
            JSONKit.outJSONInfo("{success:true,msg:'用户名已存在'}");
        }
        return NONE;
    }
    public String reg() {
        User user = new User();
        user.setClientId(UUID22.getUUID22());
        user.setUserName(userName);
        user.setPassWord(passWord);
        userService.addUser(user);
        setCurrUser(user);
        getSession().removeAttribute("allDevice");
        return "regSuccess";
    }

    public String bond() {

        User user = getCurrUser();
        Device device = new Device();
        device.setDeviceName(deviceName);
        device.setDeviceKey(UUID22.getUUID22());
        device.setUserId(user.getId());
        device.setCreateTime(new Date());
        device.setExitFlag(true);
        userService.addDevice(device);
        setDevice(userService.findAllDevice(user.getId()));

        Topic topic = new Topic();
        topic.setUserId(user.getId());
        topic.setDeviceId(device.getId());
        topic.setTopic(user.getUserName()+"/to/"+device.getDeviceKey());
        topic.setDirect(true);
        topicService.insert(topic);

        Topic topic1 = new Topic();
        topic1.setUserId(user.getId());
        topic1.setDeviceId(device.getId());
        topic1.setDirect(false);
        topic1.setTopic(device.getDeviceKey()+"/to/"+user.getUserName());
        topicService.insert(topic1);

        return "bondSuccess";
    }

    public String delDeviceById() {
        userService.delDeviceById(Integer.parseInt(deviceId));
        setDevice(userService.findAllDevice(getCurrUser().getId()));
        return "delete";
    }


    public String toReg() {
        return "toReg";
    }
    public String toLogin() {
        return "toLogin";
    }
    public String connect() {
        Information information = new Information();
        User user = getCurrUser();
        Topic topic = topicService.findByUidAndDidAndDir(user.getId(), Integer.parseInt(deviceId), true);
        Topic topic1 = topicService.findByUidAndDidAndDir(user.getId(), Integer.parseInt(deviceId), false);
        if (deviceKey.equals("0"))
            information.setClientId(user.getClientId());
        else
            information.setClientId(deviceKey);
        information.setTopic(topic.getTopic());
        information.setTopic1(topic1.getTopic());
        getSession().setAttribute("info", information);
        if (deviceKey.equals("0"))
            return "toConnect";
        else
            return "toDeviceCon";
    }



    public String toDeviceChat() {
        return "devicechat";
    }
    public String toUserChat() {
        return "userchat";
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public UserServiceInter getUserService() {
        return userService;
    }

    public void setUserService(UserServiceInter userService) {
        this.userService = userService;
    }

    public TopicServiceInter getTopicService() {
        return topicService;
    }

    public void setTopicService(TopicServiceInter topicService) {
        this.topicService = topicService;
    }
}
