<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>登录表单</title>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${baseurl}/css/login.css" type="text/css" media="all">


</head>
<!-- //Head -->

<!-- Body -->
<body>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="#" id="_form" method="post">
            <input type="text" class="username" name="username" placeholder="用户名" required="">
            <input type="password" class="password" name="password" placeholder="密码" required="">

            <ul class="tick w3layouts agileits">
                <li>
                    <input type="checkbox" id="brand1" checked="checked" class="rememberMe" name="rememberMe" value="">
                    <label for="brand1"><span></span>记住我</label>
                </li>
            </ul>
            <div class="send-button w3layouts agileits">
                <input type="button" id="loginBtn" value="登 录">
                <input type="button" id="registerBtn" class="registerBtn" value="注 册">
            </div>
        </form>
        <input id="baseurl" type="hidden" value="${baseurl}" >
    </div>

    <div class="clear"></div>
</div>
<script src="${baseurl}/js/jquery.min.js"></script>
<script src="${baseurl}/js/layer/layer.js"></script>
<script>
    //回车事件绑定
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){
            $('#loginBtn').click();
        }
    };

    //登录操作
    $('#loginBtn').click(function(){
        var username = $('.username').val();
        var password = $('.password').val();
        if(username == '') {
            layer.msg('用户名不可为空！');
            return false;
        }
        if(password == '') {
            layer.msg('密码不可为空！');
            return false;
        }
        var data = {pswd:password,email:username,rememberMe:$(".rememberMe").is(':checked')};
        var load = layer.load();
        var baseurl = $("#baseurl").val();
        $.ajax({
            url : baseurl+"/user/submitLogin.tkm",
            type : "POST",
            data : data,
            dataType: 'json',
            success : function(result) {
                layer.close(load);
                if(result && result.code != 200){
                    layer.msg(result.message,function(){});
                    $('.password').val('');
                    return;
                }else{
                    layer.msg('登录成功！');
                    // setTimeout(function(){
                    //登录返回
                    window.location.href= result.back_url || baseurl+"/";
                    // },1000)
                }
            }
        });

    });
    //注册
    $("#registerBtn").click(function(){
        window.location.href="register.tkm";
    });
</script>
</body>
<!-- //Body -->

</html>