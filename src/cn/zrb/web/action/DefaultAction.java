package cn.zrb.web.action;


import cn.zrb.entity.Device;
import cn.zrb.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 2016/12/29.
 */
public class DefaultAction extends ActionSupport {

    protected User currUser = null;
    protected String s = null;

    protected void setReqAttr(String s,Object obj) {
        ServletActionContext.getRequest().setAttribute(s,obj);
    }

    protected HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    protected User getCurrUser() {
        User user = (User) this.getSession().getAttribute("currUser");
        return user;
    }

    protected void setCurrUser(User user) {
        this.getSession().setAttribute("currUser",user);
    }

    protected List<Device> getDevice() {
        List<Device> device = (List<Device>) this.getSession().getAttribute("allDevice");
        return device;
    }

    protected void setDevice(List<Device> device) {
        this.getSession().setAttribute("allDevice",device);
    }

    protected String getReqParm(String attr) {
        return ServletActionContext.getRequest().getParameter(attr);
    }

    protected void setStopStatus(String s) {
        this.getSession().setAttribute("stop",s);
    }

    protected String getStopStatus() {
        return (String)this.getSession().getAttribute("stop");
    }
}
