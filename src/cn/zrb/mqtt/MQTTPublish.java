package cn.zrb.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;  

  
public class MQTTPublish {  

//	public static final String HOST = "tcp://localhost:61613";
    public static final String HOST = "tcp://192.168.67.129:61613";


    public MqttClient client;  
    
    private MqttTopic topic;  
    private String userName = "admin";
    private String passWord = "password";
  
    public MqttMessage message;  

    public MQTTPublish(String clientid,String TOPIC) throws MqttException {
    	
        client = new MqttClient(HOST, clientid, new MemoryPersistence());  
        connect(userName, passWord, TOPIC);  
    }  
      
    private void connect(String userName, String passWord, String TOPIC) {  
        MqttConnectOptions options = new MqttConnectOptions();  
        options.setCleanSession(false);
        options.setUserName(userName);  
        options.setPassword(passWord.toCharArray());  
        options.setConnectionTimeout(10);   
        options.setKeepAliveInterval(20);  
        try {  
               client.setCallback(new MQTTCallback());
        	
               client.connect(options);  
               topic = client.getTopic(TOPIC);  
        } catch (Exception e) {  
               e.printStackTrace();  
        }  
    }  
      
    public void publish(MqttMessage message) throws MqttException{
        //发送信息并获取回执
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();  
        System.out.println("Token is complete:" + token.isComplete());  
    }  
    
    public static void doPub(String clientid, String TOPIC, String msg) throws MqttException{
        MQTTPublish mqttpub =  new MQTTPublish(clientid,TOPIC);
        mqttpub.message = new MqttMessage();
        mqttpub.message.setQos(2);
        mqttpub.message.setRetained(true);
        mqttpub.message.setPayload(msg.getBytes());
        mqttpub.publish(mqttpub.message);
        System.out.println("Ratained state:" + mqttpub.message.isRetained());

        mqttpub.client.disconnect();
        System.out.println("Disconnected");
    }
  
} 
