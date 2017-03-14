<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>regist(注册)</title>

    <link rel="stylesheet" type="text/css" href="css/regist.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        function findByUserName() {
            $.ajax({
                url: 'user_findByUserName.do',
                type: 'POST',
                processDate: true,
                data: "userName=" + $("#uname").val(),
                dataType: 'json',
                success: function (result) {
                    var json = eval(result);
                    if(json.msg != null) {
                        alert(json.msg);
                        return false;
                    }
                    return true;
                }
            });
        }
    </script>
</head>
<body id="home">
<div class="rain">
    <div class="border start">
        <form action="user_reg.do" method="post">
            <label for="user">User</label>
            <input type="text" placeholder="UserName" name="userName" id="uname" onblur="findByUserName()"/>
            <label for="pass">Password</label>
            <input type="password" placeholder="Password" name="passWord" id="pwd"/>
            <input type="submit" value="REG"/>
        </form>
    </div>
</div>
<div class="error">
    <s:fielderror>
        <s:param>userName</s:param>
    </s:fielderror>
    <s:fielderror>
        <s:param>Password</s:param>
    </s:fielderror>
</div>
</body>
</html>
