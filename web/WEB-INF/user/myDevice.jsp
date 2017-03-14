<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>myDevice</title>
    <link type="text/css" rel="stylesheet" href="css/myDevice.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myDevice.js"></script>
</head>
<body>

<div class="contain">
    <h2 class="market">设备列表</h2>
    <hr/>
    <button title="创建设备" id="create-button"> 十 创建设备</button>
    <table cellpadding="0" cellspacing="0" width="100%">
        <tbody>
        <tr>
            <th id="cell1" class="table-th" style="width: 120px;">
                <div class="ui-table">设备名称</div>
            </th>
            <th id="cell2" class="table-th" style="width: 180px;">
                <div class="ui-table">描述</div>
            </th>
            <th id="cell3" class="table-th" style="width: 220px;">
                <div class="ui-table">生成密匙</div>
            </th>
            <th id="cell4" class="table-th" style="width:200px;">
                <div class="ui-table">创建时间</div>
            </th>
            <th id="cell5" class="table-th last-tb-th" style="width:180px;">
                <div class="ui-table">操作</div>
            </th>
        </tr>
        <c:if test="${sessionScope.allDevice != '[]'}">
            <c:forEach items="${allDevice}" var="device">
                <tr>
                    <td>${device.deviceName}</td>
                    <td></td>
                    <td>${device.deviceKey}</td>
                    <td><fmt:formatDate value="${device.createTime}" pattern="yyyy-MM-dd hh:mm:ss" type="date" dateStyle="long" /></td>
                    <td>
                        <a href="user_connect.do?deviceId=${device.id}&deviceKey=0">连接</a>
                        <a href="user_connect.do?deviceId=${device.id}&deviceKey=${device.deviceKey}" target="_blank">模拟设备</a>
                        <a href="#" onclick="isDelete(${device.id});" name="deviceId">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${sessionScope.allDevice == '[]'}">
            <tr>
                <td colspan="5">
                    <div class="noDevice">
                        <img src="img/noEntity.png" width="300px" height="150px"/>
                    </div>
                </td>
            </tr>

        </c:if>
        </tbody>
    </table>
</div>
<div class="screen-bg">
    <div class="hide-dialog">
        <div class="dialog-head">
            <div class="dialog-head-text">创建设备</div>
            <div class="dialog-head-icon">X</div>
        </div>
        <form action="user_bond.do" method="post" onsubmit="return isNull()">
            <div class="dialog-name">
                <label><i>＊</i>名称：</label>
                <input type="text" name="deviceName" id="deviceName">
            </div>
            <div class="dialog-submit">
                <input type="submit" value="创建" id="create">
            </div>
        </form>
    </div>
</div>
</body>
</html>
