package cn.zrb.util;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class Util {
	public static MqttMessage mqm = null;
	public static Boolean modifiedFlag;

	public static MqttMessage getMqm() {
		return mqm;
	}

	public static void setMqm(MqttMessage mqm) {
		Util.mqm = mqm;
		modifiedFlag = true;
	}

	public static void resetFlag(){
		modifiedFlag = false;
	}
	public static boolean isMsgModified() {
		return modifiedFlag;
	}
}
