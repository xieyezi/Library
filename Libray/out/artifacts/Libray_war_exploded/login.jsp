<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/28
  Time: 下午3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>中山图书馆管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>

</head>

<body data-type="login">
<script src="assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content">
            <%--<div class="tpl-login-logo">--%>

            <%--</div>--%>
            <div style="padding-bottom: 5%">
                <img src="assets/images/libLog.jpg">
            </div>

            <form action="./LogincheckServlet" method="post" class="am-form tpl-form-line-form">
                <div class="am-form-group" style="padding-bottom: 5%">
                    <label class="am-u-sm-3 am-form-label">选择类型</label>
                    <div class="am-u-sm-9">
                        <select name="Type" data-am-selected="{searchBox: 1}" style="display: none;">
                            <option value="option1">读者</option>
                            <option value="option2">图书管理员</option>
                            <option value="option3">系统管理员</option>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="name" name="name" placeholder="请输入账号">

                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" name="password"
                           placeholder="请输入密码">

                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">

                        记住密码
                    </label>

                </div>
                <div class="am-form-group">

                    <button type="submit"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    //取出传回来的参数error并与yes比较
    var error1 = '<%=request.getParameter("login")%>';
    var error2 = '<%=request.getParameter("islogin")%>';
    var error3 = '<%=request.getParameter("change")%>';
    if (error1 == 'no') {
        alert("账号名或者密码错误！");
    }
    if (error2 =='no'){
        alert("您未登录！");
    }
    if (error3 =='yes'){
        alert("修改成功，请重新登录！");
    }
</script>
</body>

</html>
