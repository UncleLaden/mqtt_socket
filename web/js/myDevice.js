window.onload = function(){
    $("#create-button").click(function(){
        $(".screen-bg").css("display", "block");
    });

    $("#create").click(function(){
        $(".screen-bg").css("display", "none");
    });
    $(".dialog-head-icon").click(function(){
        $(".screen-bg").css("display", "none");
    });
}

function isDelete(deviceId) {
    var con = confirm('删除当前设备将清空所有信息，是否继续？');
    if(con)
        location.href="user_delDeviceById.do?deviceId=" + deviceId;
    else
        return;
}

function isNull() {
        if(!$.trim($('#deviceName').val())) {

            alert("设备名称不能为空");
            return false;
        }
}