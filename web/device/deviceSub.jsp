<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>deviceSub</title>

  </head>

  <body>

  <h1>设备接受</h1>
    <form action="subBy_device.do" method="post">
      <input name="tp" type="text"/>
      <input type="submit" value="接受"/>
    </form>
  ${msg}
  </body>
</html>
