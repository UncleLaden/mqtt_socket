<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connect</title>
    <link rel="stylesheet" href="css/connect.css" media="screen" type="text/css" />
</head>

<body>

<div id="convo" data-from="Sonu Joshi">
    <ul class="chat-thread">

    </ul>
</div>
<div class="send-message">
    <textarea class="message"></textarea>
    <input type="hidden" id="ppt" value="firstTime"/>
    <input type="button" value="send" onclick="sendMsg()"/>
    <input type="button" class="connect" id="changeBtn" value="connect" onclick="return changeBtn()"/>
</div>

<script type="text/javascript" src='js/jquery.js'></script>
<script type="text/javascript" src="js/connect.js"></script>
</body>
</html>
