<%@ page import="domain.User" %>
<%@ page import="com.xieyezi.CollectQuery" %>
<%@ page import="domain.Collect" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/4/27
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="">
<%
    User user = (User) session.getAttribute("User");
    if (user==null){
        response.sendRedirect("login.jsp");return;
    }
    int id = user.getId();
    CollectQuery collectQuery = new CollectQuery();
    Vector<Collect> collects = collectQuery.getCollect(id);
    collectQuery.closeConnection();
%>
<head>
    <meta charset="utf-8">
    <title>Xydesign</title>
    <meta name="description" content="">
    <meta name="msapplication-tap-highlight" content="yes" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0" />
    <link rel="icon" href="assets/images/favicon.ico" type="image/icon" />
    <link rel="shortcut icon" href="assets/images/favicon.ico" type="image/x-icon" />
    <!--  Bootstrap 3-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <!-- Animate -->
    <link rel="stylesheet" href="assets/css/animate.css">
    <!-- Web Icons Font -->
    <link rel="stylesheet" href="assets/css/et-line.css">
    <link rel="stylesheet" href="assets/css/ionicons.css">
    <!-- Costum Styles -->
    <link rel="stylesheet" href="assets/css/work.css">
    <link rel="stylesheet" href="assets/css/foot.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body>
<div class="header" id="top">
    <div class="container">
        <div class="logo">
            <a href="index.jsp">
                <img src="assets/images/logo.png" alt="Logo">
            </a>
        </div>

        <!-- Menu Hamburger (Default) -->
        <button class="main-menu-indicator" id="open-button">
            <span class="line"></span>
        </button>

        <div class="menu-wrap" style="background-image: url(assets/images/menu.jpg)">
            <div class="menu-content">
                <div class="navigation">
                    <span class="fa fa-times fa-2x close-menu" id="close-button"></span>
                    <div class="search-wrap js-ui-search">
                        <input class="js-ui-text" type="text" placeholder="寻找你的梦想">
                        <span class="eks js-ui-close"></span>
                    </div>
                </div>
                <nav class="menu">
                    <div class="menu-list">
                        <ul>
                            <li class="menu-item-has-children">
                                <a href="index.jsp">首页</a>

                            </li>
                            <li class="menu-item-has-children">
                                <a href="work.jsp">定制模板</a>
                            </li>
                            <li>
                                <a href="zixun.html">资讯</a>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="about.jsp">关于我们</a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="about.jsp">关于我们</a>
                                    </li>
                                    <li>
                                        <a href="about.jsp">给我们留言</a>
                                    </li>
                                    <li>
                                        <a href="about.jsp">寻找合作</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="userCenter.jsp">个人中心</a>
                            </li>
                            <li>
                                <a href="login.jsp">登录</a>
                            </li>
                            <li>
                                <a href="register.jsp">注册</a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <div class="hidden-xs">
                    <div class="menu-social-media">
                        <ul>
                            <li>
                                <a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-weibo"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                            </li>
                        </ul>
                    </div>

                    <div class="menu-information">
                        <ul>
                            <li><span>电话:</span> 000 000 000</li>
                            <li><span>邮箱:</span> info@mail.com</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Menu Hamburger (Default) -->

    </div>
</div>
<div class="col-md-11 col-md-offset-1 col-xs-11 col-xs-offset-1 col-sm-11  col-sm-offset-1">
    <div class="row">
        <div class="services-home-page">
            <div class="col-md-12 wow fadeInUp" data-wow-duration="0.2s" data-wow-delay="0.2s">
                <div class="row">
                    <div class="services-icon img-responsive">
                        <span class="fa fa-bell-o"></span>
                    </div>
                    <h4>您的收藏</h4>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container margin-top margin-bottom">
    <div class="row">
        <%
            for (int i = 0;i<collects.size();i++){
        %>
        <div class=" col-md-4 col-xs-6 col-sm-4 ">
            <img class="img-responsive" src="assets/images/work/<%=collects.get(i).getModelName()%>.png" />
            <div class="down">
                <div class="col-md-3 col-md-offset-1 col-xs-3">
                    <a href="">预 览</a>
                </div>
                <div class="col-md-4 col-md-offset-1 col-xs-4 col-xs-offset-1">
                    <a href="./cancel?modelname=<%=collects.get(i).getModelName()%>">取消收藏</a>
                </div>
                <div class="col-md-3 col-xs-3">
                    <a href="">下 载</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>

<!-- footer section -->
<footer class="footer fadeInUp wow">
    <div class="container-fluid">
        <div class="col-md-2 left">
        </div>
        <div class="col-md-2 left">
            <h4>联系我们</h4>
            <p> 电话: 18875214426 <br> 邮箱 :
                <a href="mailto:xieyezi666@icloud.com"> xieyezi666@icloud.com </a>
            </p>
        </div>
        <div class="col-md-2 left">
            <h4>其他</h4>
            <ul class="footer-share">
                <li>
                    <a href="#"><i class="fa fa-weibo"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                </li>
            </ul>
        </div>
        <div class="col-md-3 right">
            <p>© 2018 All rights reserved.<br> Design with <i class="fa fa-heart pulse"></i> by
                <a href="http://www.xieyezi.com/">Xieyezi</a>
            </p>
        </div>
        <div class="col-md-3 right">
            <p class="text-center">
                <a href="#top" class="gototop"><i class="fa fa-chevron-up fa-2"></i></a>
            </p>
        </div>
    </div>
</footer>
<!-- footer section -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script data-pace-options='{ "ajax": false }' src="assets/js/pace.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/isotope.pkgd.min.js"></script>
<script src="assets/js/imagesloaded.pkgd.min.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/ajax.js"></script>
<script src="assets/js/classie.js"></script>
</body>

</html>

