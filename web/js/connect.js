function sendMsg() {
    var msg = $.trim($('.message').val());
    $(".message").text("");
    if(!msg) {
        alert("信息不能为空");
        return;
    }
    $(".chat-thread").append("<li class='chat-from-user'>" + msg + "</li>");
    $.ajax({
        url: "pubBy_user.do",
        type: "POST",
        processDate: true,
        data:{"deviceId":GetQueryString('deviceId'),"msg": msg},
        dataType: "json",
        success: function () {
            return;
        }
    });
}

function changeBtn() {
    var btn = $("#changeBtn");
    if(btn.val() =="connect") {
        btn.attr("class", "stop");
        btn.val("stop");
        longPolling("f");
        return false;
    }
    if(btn.val() == "stop") {
        btn.attr("class", "connect");
        btn.val("connect");
        longPolling("t");
        return false;
    }
}

function GetQueryString(name)
{
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return (r[2]); return null;
}

function longPolling(stopStatus) {
    $.ajax({
        url: "subBy_user.do",
        type: "POST",
        processDate: true,
        data:{"deviceId":GetQueryString('deviceId'),"oldValue":$("#ppt").attr("value"),"stop":stopStatus},
        dataType: "json",
        success: function (result) {
            var json = eval(result);
            alert(json.st);
            if(json.st == "f") {
                $("#ppt").val(json.dt);
                $(".chat-thread").append("<li class='chat-from-device'>" + json.dt + "</li>");
                longPolling("f");
            } else {
                // alert(json.st);
                return;
            }
        }
    });
}