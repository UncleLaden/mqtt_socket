package cn.zrb.entity;


import java.util.Set;

/**
 * Created by admin on 2017/2/21.
 */
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String clientId;
    private Set<Topic> topicsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Set<Topic> getTopicsById() {
        return topicsById;
    }

    public void setTopicsById(Set<Topic> topicsById) {
        this.topicsById = topicsById;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", clientId='" + clientId + '\'' +
                ", topicsById=" + topicsById +
                '}';
    }
}
