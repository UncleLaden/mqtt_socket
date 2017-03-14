package cn.zrb.web.action;

import cn.zrb.entity.Topic;
import cn.zrb.entity.User;
import cn.zrb.mqtt.MQTTSubscribe;
import cn.zrb.service.MessageServiceInter;
import cn.zrb.service.TopicServiceInter;
import cn.zrb.util.JSONKit;
import cn.zrb.util.Util;

import javax.annotation.Resource;

public class SubscribeAction extends DefaultAction{

	public String deviceId;
	public String deviceKey;

	@Resource
	TopicServiceInter topicService;
	@Resource
	MessageServiceInter messageService;

	public String user() throws Exception {
		User user = getCurrUser();
		Topic topic = topicService.findByUidAndDidAndDir(user.getId(), Integer.parseInt(deviceId),false);
		String oldValue = getReqParm("oldValue");

		System.out.println("user Sub from"+topic.getTopic());

		MQTTSubscribe client = new MQTTSubscribe();
		client.start(user.getClientId(),topic.getTopic());
        if(getReqParm("stop").equals("t")) {
            client.stop();
            System.out.println("stop");
			JSONKit.outJSONInfo("{success:true,st:'t'}");
			setStopStatus("t");
			return NONE;
        }
        while (true) {
			System.out.println("1");
            if(Util.getMqm()!=null) {
				System.out.println("2");
				if (!oldValue.equals(new String(Util.getMqm().getPayload()))) {
					System.out.println(new String(Util.getMqm().getPayload())+"--"+oldValue);
                    JSONKit.outJSONInfo("{success:true,dt:'" + new String(Util.getMqm().getPayload()) + "',st:'f'}");
                    Util.setMqm(null);
					break;
                } else {
					System.out.println("3");
					if (getStopStatus()== null) {
						System.out.println(4);
						Thread.sleep(1000);
					} else {
						System.out.println(5);
						setStopStatus(null);
						break;
					}
				}
            }
//            else {
//				Thread.sleep(100);
//            }

        }
		return NONE;
	}

	public String device() throws Exception {

		User user = getCurrUser();
		Topic topic = topicService.findByUidAndDidAndDir(user.getId(), Integer.parseInt(deviceId),true);
        String oldValue = getReqParm("oldValue");
		System.out.println("device Sub from"+topic.getTopic());

		MQTTSubscribe client = new MQTTSubscribe();
		client.start(deviceKey, topic.getTopic());

		if(getReqParm("stop").equals("t")) {
			client.stop();
			System.out.println("device stop");
			JSONKit.outJSONInfo("{success:true,st:'t'}");
			setStopStatus("t");
			return NONE;
		}
		while (true) {
			System.out.println("11");
			if(Util.getMqm()!=null) {
				System.out.println("22");
				if (!oldValue.equals(new String(Util.getMqm().getPayload()))) {
					System.out.println(new String(Util.getMqm().getPayload())+"--"+oldValue+oldValue.equals(new String(Util.getMqm().getPayload())));
					JSONKit.outJSONInfo("{success:true,dt:'" + new String(Util.getMqm().getPayload()) + "',st:'f'}");
					Util.setMqm(null);
                    break;
                } else {
					System.out.println("33");
					if (getStopStatus()== null) {
						System.out.println(44);
						Thread.sleep(1000);
					} else {
						System.out.println(55);
						setStopStatus(null);
						break;
					}
                }
            }
//            else {
//                Thread.sleep(100);
//            }

		}
		return NONE;
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
}
