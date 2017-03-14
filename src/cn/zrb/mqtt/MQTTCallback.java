package cn.zrb.mqtt;

import cn.zrb.util.Util;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MQTTCallback implements MqttCallback {


	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost, reconnect please!");
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		try {
			System.out.println("deliveryComplete---------"+ token.isComplete());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Message arrived on topic:"+topic);
		System.out.println("Message arrived on QoS:"+message.getQos());
		System.out.println("Message arrived on content:"+new String(message.getPayload()));
		Util.setMqm(message);
	}

}
