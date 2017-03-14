<%@ page language="java" pageEncoding="utf8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>login(登录)</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">

  </head>

  <body>
  <div class="htmleaf-container">
      <div class="wrapper">
          <div class="container">
              <h1>Welcome</h1>

              <form class="form" action="user_login.do" method="post">
                  <input type="text" placeholder="Username" name="userName" value="${currUser.userName}">
                  <input type="password" placeholder="Password" name="passWord" value="${currUser.passWord}">
                  <input type="submit" id="login-button" value="Login"/>
              </form>
          </div>

          <ul class="bg-bubbles">
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
              <li></li>
          </ul>
      </div>
  </div>
  </body>
</html>
