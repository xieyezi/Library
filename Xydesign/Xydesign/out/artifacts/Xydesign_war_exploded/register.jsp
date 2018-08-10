<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/4/25
  Time: 下午5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>注册</title>
<link rel="stylesheet" href="assets/css/login.css">
<link rel="icon" href="assets/images/favicon.ico" type="image/icon" />
<link rel="shortcut icon" href="assets/images/favicon.ico" type="image/x-icon" />
<body>

<div class="register-container">
    <h1>欢迎</h1>

    <div class="connect">
        <p>我们一直在等你</p>
    </div>

    <form action="./regis" method="post" id="registerForm">
        <div>
            <input type="text" name="username" class="username" placeholder="您的用户名" autocomplete="off" />
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="text" name="phone_number" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number" />
        </div>
        <div>
            <input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
        </div>

        <button id="submit" type="submit">注 册</button>
    </form>
    <div>
        <a href="login.jsp">
            <button type="button" class="register-tis">已经有账号？</button>
        </a>
    </div>

    <div>
        <a href="index.jsp">
            <button type="button" class="back">返回首页</button>
        </a>
    </div>
</div>

</body>
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/js/login.js"></script>
<!--背景图片自动更换-->
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<!--表单验证-->
<script src="assets/js/jquery.validate.min.js"></script>

</html>