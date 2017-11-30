<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>注册</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //Meta-Tags -->

    <!-- Style -->
    <link rel="stylesheet" href="${baseurl}/css/login.css" type="text/css" media="all">


</head>
<!-- //Head -->

<!-- Body -->
<body>

<div class="container w3layouts agileits">

    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="#" id="_form" method="post">
            <input type="text" name="nickname" id="nickname" class="username" placeholder="用户名" required="">
            <input type="text" name="username"  id="email" class="email" placeholder="邮箱/手机号" required="">
            <input type="password" name="password" id="password" class="password" placeholder="密码" required="">
            <input type="password" placeholder="请再次输入密码" id="re_password" class="re_password" required="">
            <div style="text-align: left; display: inline-block" id="vcode">
                <input type="text" name="vcode" class="vcode"  placeholder="验证码" style="width: 40%;">
                <img width="50%" src="${baseurl}/common/getVCode.tkm" />
            </div>

            <div class="send-button w3layouts agileits">
                <input type="button" class="registerBtn" value="注册">
                <input type="button" id="loginBtn" value="登录">
            </div>
            <div class="error"><span>+</span></div>
        </form>
        <input id="baseurl" type="hidden" value="${baseurl}" >
    </div>
    <div class="clear"></div>
</div>
<script src="${baseurl}/js/jquery.min.js"></script>
<script src="${baseurl}/js/layer/layer.js"></script>
<script>
    var baseurl = $("#baseurl").val();
    //验证码
    $("#vcode").on("click",'img',function(){
        /**动态验证码，改变地址，多次在火狐浏览器下，不会变化的BUG，故这样解决*/
        var i = new Image();
        i.src = baseurl + '/common/getVCode.tkm?'  + Math.random();
        $(i).replaceAll(this);
    });
    $('.registerBtn').click(function(){


        var nickname = $("#nickname").val();
        var username = $("#email").val();

        var re_password = $("#re_password").val();
        var password = $("#password").val();


        var vcode = $(".vcode").val();

        if(nickname == '') {
            layer.msg('用户名不可为空！');
            return false;
        }
        if(username == '') {
            layer.msg('邮箱/电话不可为空！');
            return false;
        }
        if(password == '') {
            layer.msg('密码不可为空！');
            return false;
        }
        if(vcode == '') {
            layer.msg('验证码不可为空！');
            return false;
        }

        if(password != re_password){
            return layer.msg('2次密码输出不一样！',function(){}),!1;
        }

        if($('[name=vcode]').val().length !=4){
            return layer.msg('验证码的长度为4位！',function(){}),!1;
        }

        var data = {nickname:nickname,email:username,pswd:password,vcode:vcode};
        var load = layer.load();
        $.ajax({
            url : baseurl+"/user/subRegister.tkm",
            type : "POST",
            data : data,
            dataType: 'json',
            success : function(result) {
                layer.close(load);
                if(result && result.code!= 200){
                    return layer.msg(result.message,function(){}),!1;
                }else{
                    layer.msg('注册成功！' );
                    window.location.href= result.back_url || baseurl + "/";
                }
            }
        });

    });
    //跳转
    $("#loginBtn").click(function(){
        window.location.href="login.tkm";
    });
</script>
</body>
<!-- //Body -->

</html>
