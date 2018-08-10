<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/28
  Time: 下午1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>

<link rel="stylesheet" href="assets/css/search.css">

<body>

<div class="login-container">
  <h1>欢迎使用中山图书馆系统</h1>

  <div class="connect">
    <p>您想找什么书？</p>
  </div>
  <form action="./SearchServlet" method="post" id="searchForm">
    <div>
      <input type="text" name="search" class="search" placeholder="图书书名 / 图书编号 / 作者" autocomplete="off" />
    </div>
    <button id="submit" type="submit">搜 索</button>
  </form>
  <div class="loginbutton">
    <a href="login.jsp">是否登录?</a>
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
