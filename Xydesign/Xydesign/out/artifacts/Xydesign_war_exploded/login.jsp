<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/4/25
  Time: 下午3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="assets/css/login.css">
<link rel="icon" href="assets/images/favicon.ico" type="image/icon" />
<link rel="shortcut icon" href="assets/images/favicon.ico" type="image/x-icon" />
<body>

<div class="login-container">
    <h1>欢迎</h1>

    <div class="connect">
        <p>我们携手并进</p>
    </div>

    <form action="./logincheck" method="post" id="loginForm">
        <div>
            <input type="text" name="username" class="username" placeholder="用户名"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码"/>
        </div>
        <button id="submit" type="submit">登 录</button>
    </form>
    <div>
        <a href="register.jsp">
            <button type="button" class="register-tis">还有没有账号？</button>
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
<script>

    //取出传回来的参数error并与yes比较
    var error1 ='<%=request.getParameter("login")%>';
    var error2 ='<%=request.getParameter("regis")%>';
    if(error1=='yes'){
        alert("用户名或者密码错误!");
    }
    if (error2=='yes'){
        alert("注册成功，请登录！")
    }
</script>
</html>
