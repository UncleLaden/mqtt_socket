<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/2/27
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript">

            function longPolling() {
                $.ajax({
                    url: "subBy_device.do",
                    type: "POST",
                    processDate: true,
                    data:{"tp":"stupid/to/BSgcJGD8TKyOibdojNKkHg","oldValue":$("#ppt").attr("value"),"stop":false},
                    dataType: "json",
                    success: function (result) {

                        var json = eval(result);
                        $("#state").append("data: { " + json.dt + "}<br/>");

                        $("#ppt").val(json.dt);
                        longPolling();
                    }
                });
            }

            function stop() {
                $.ajax({
                    url: "subBy_device.do",
                    type: "POST",
                    data:{"tp":"stupid/to/BSgcJGD8TKyOibdojNKkHg","oldValue":$("#ppt").attr("value"),"stop":"t"},
                    processDate: true,
                    dataType: "json",
                    success: function () {
                        alert("Stop");
                    }
                });
            }

    </script>
</head>
<body>
    <input type="button" id="btn1" value="start" onclick="longPolling()"/>
    <input type="button" id="btn2" value="stop" onclick="stop()"/>
    <input type="hidden" id="ppt" value="firstTime"/>
    <div id="state"></div>
</body>
</html>
