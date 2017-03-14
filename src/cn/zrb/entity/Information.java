package cn.zrb.entity;

/**
 * Created by admin on 2017/3/13.
 */
public class Information {
  //  public String host = "localhost";
    public String host = "192.168.67.129";
    public String port = "61623";
    public String clientId;
    public String username = "admin";
    public String password = "password";
    public String topic;
    public String topic1;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTopic() {
        return topic;
    }

    public String getTopic1() {
        return topic1;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTopic1(String topic1) {
        this.topic1 = topic1;
    }
}
