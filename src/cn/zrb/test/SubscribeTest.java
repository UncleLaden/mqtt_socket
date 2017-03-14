package cn.zrb.test;

import cn.zrb.mqtt.MQTTSubscribe;
import org.eclipse.paho.client.mqttv3.MqttException;

public class SubscribeTest {
    
    
    public static void main(String[] args) throws MqttException {     
    	
    	String clientid ="sub";
        String TOPIC = "aaa";
        MQTTSubscribe client = new MQTTSubscribe();
        client.start(clientid, TOPIC);
    }
}
