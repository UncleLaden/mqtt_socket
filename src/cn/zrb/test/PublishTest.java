package cn.zrb.test;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import cn.zrb.mqtt.MQTTPublish;

public class PublishTest {
	
    public static void main(String[] args) throws MqttException {  

    	String clientid = "pub";
    	String userName = "admin";  
        String passWord = "password"; 
        String TOPIC = "aaa";
        String fuzai = "hei man";
        MQTTPublish mqttpub =  new MQTTPublish(clientid,TOPIC);
        mqttpub.message = new MqttMessage();
        mqttpub.message.setQos(2);
        mqttpub.message.setRetained(true);
        mqttpub.message.setPayload(fuzai.getBytes());
        mqttpub.publish(mqttpub.message);
        System.out.println("Ratained state:" + mqttpub.message.isRetained());

        mqttpub.client.disconnect();
        System.out.println("Disconnected");
        System.exit(0);
    }  
}
