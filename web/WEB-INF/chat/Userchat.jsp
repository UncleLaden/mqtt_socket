<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User</title>
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.responsive.css" rel="stylesheet">
    <style type="text/css">
        body { padding-top: 40px; }
    </style>
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Apollo MQTT WebSocket Chat Example</a>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6">
            <div id="connect">
                <div class="page-header">
                    <h2>Server Login</h2>
                </div>
                <form class="form-horizontal" id='connect_form'>

                        <div class="form-actions">
                            <button id='connect_submit' type="submit" class="btn btn-large btn-primary">Connect</button>
                        </div>
                </form>
            </div>
            <div id="connected" style="display:none">
                <div class="page-header">
                    <h2>Chat Room</h2>
                </div>
                <div id="messages">
                </div>
                <form class="well form-search" id='send_form'>
                    <button class="btn" type="button" id='disconnect' style="float:right">Disconnect</button>
                    <input class="input-medium" id='send_form_input' placeholder="Type your message here" class="span6"/>
                    <button class="btn" type="submit">Send</button>
                </form>
            </div>
        </div>
        <div class="span4">
            <div class="page-header">
                <h2>Debug Log</h2>
            </div>
            <pre id="debug"></pre>
        </div>
    </div>
</div>

<!-- Scripts placed at the end of the document so the pages load faster -->
<script src='js/jquery.js'></script>
<script src="js/mqttws31.js"></script>
<script>//<![CDATA[
$(document).ready(function(){

    $("#connect_clientId").val("example-"+(Math.floor(Math.random() * 100000)));
    if( !window.WebSocket) {
        $("#connect").html("\
        <h1>Get a new Web Browser!</h1>\
        <p>\
        Your browser does not support WebSockets. This example will not work properly.<br>\
        Please use a Web Browser with WebSockets support (WebKit or Google Chrome).\
        </p>\
    ");
    } else {

        var client, destination;

        $('#connect_form').submit(function() {
            var host = '${info.host}';
            var port = '${info.port}';
            var clientId = '${info.clientId}';
            var user = '${info.username}';
            var password = '${info.password}';

            destination = '${info.topic1}';


            client = new Messaging.Client(host, Number(port), clientId);

            client.onConnect = onConnect;

            client.onMessageArrived = onMessageArrived;
            client.onConnectionLost = onConnectionLost;

            client.connect({
                userName:user,
                password:password,
                onSuccess:onConnect,
                onFailure:onFailure
            });
            return false;
        });

        // the client is notified when it is connected to the server.
        var onConnect = function(frame) {
            debug("connected to MQTT");
            $('#connect').fadeOut({ duration: 'fast' });
            $('#connected').fadeIn();
            client.subscribe(destination);
        };

        // this allows to display debug logs directly on the web page
        var debug = function(str) {
            $("#debug").append(document.createTextNode(str + "\n"));
        };

        $('#disconnect').click(function() {
            client.disconnect();
            $('#connected').fadeOut({ duration: 'fast' });
            $('#connect').fadeIn();
            $("#messages").html("")
            return false;
        });

        $('#send_form').submit(function() {
            var text = $('#send_form_input').val();
            if (text) {
                message = new Messaging.Message(text);
                message.destinationName = '${info.topic}';
                client.send(message);
                $.ajax({
                    url: "pub.do",
                    type: "POST",
                    processDate: true,
                    data:{"topic":'${info.topic}',"msg": text},
                    dataType: "json",
                    success: function () {
                        return;
                    }
                });
                $('#send_form_input').val("");
            }
            return false;
        });

        function onFailure(failure) {
            debug("failure");
            debug(failure.errorMessage);
        }

        function onMessageArrived(message) {
            var p = document.createElement("p");
            var t = document.createTextNode(message.payloadString);
            p.appendChild(t);
            $("#messages").append(p);
        }

        function onConnectionLost(responseObject) {
            if (responseObject.errorCode !== 0) {
                debug(client.clientId + ": " + responseObject.errorCode + "\n");
            }
        }


    }
});
//]]></script>

</body>
</html>
