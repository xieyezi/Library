<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/4/26
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="">

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
<div class="container">
    <div class="loaction col-lg-12 col-md-12">
        <!--引入高德地图API-->
        <div id="map"></div>
    </div>
</div>

<div class="container margin-top">
    <div class="contact-wrapper">
        <div class="row">
            <div class="col-md-3">
                <div class="contact-info">
							<span class="icon-info">
                        <i class="pe-7s-phone"></i>
                    </span>
                    <span class="title-info">电话:</span>
                    <span class="description-info">188-7521-4426</span>
                </div>

                <div class="contact-info">
							<span class="icon-info">
                        <i class="pe-7s-map-marker"></i>
                    </span>
                    <span class="title-info">地址:</span>
                    <span class="description-info">重庆市巴南区学府大道69号</span>
                </div>

                <div class="contact-info">
							<span class="icon-info">
                        <i class="pe-7s-mail"></i>
                    </span>
                    <span class="title-info">邮箱:</span>
                    <span class="description-info">xieyezi666@icloud.com</span>
                </div>
            </div>

            <form action="./message" method="post">
                <div class="contact-form">
                    <div class="col-md-4">
                        <input name="messageName" type="text" placeholder="怎么称呼您？">
                        <input name="messageEmail" type="text" placeholder="请输入您的邮箱">
                        <!-- <input type="text" placeholder="你想对我们说什么？">-->
                    </div>
                    <div class="col-md-5">
                        <textarea name="message" placeholder="你想对我们说什么？"></textarea>
                        <input type="submit" value="提交">
                    </div>
                </div>
            </form>
        </div>
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
<!--for map js-->
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.0&key=204a2b5e0ffa1d288102d3c319d48331"></script>
<!--map-ui- js-->
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<script>
    //创建一个地图对象
    var map = new AMap.Map('map', {
        resizeEnable: true,
        zoom: 15,
        center: [106.530257, 29.452519]
    });
    //地图控件
    AMapUI.loadUI(['control/BasicControl'], function(BasicControl) {
        //添加一个缩放控件
        map.addControl(new BasicControl.Zoom({
            position: 'rb' //位置设置在右下角
        }));

        //图层切换控件
        map.addControl(new BasicControl.LayerSwitcher({
            position: 'rt' //位置设置在右上角
        }));
    });
    //禁止鼠标滚轮缩小或放大地图
    map.setStatus({
        scrollWheel: false
    });
    //自定义点标记图标
    new AMap.Marker({
        map: map,
        position: [106.530257, 29.452519],
        icon: new AMap.Icon({
            size: new AMap.Size(50, 60), //图标大小
            image: "assets/images/location.png",
            offset: new AMap.Pixel(-10, 0),
        })
    });
</script>
<script>
    //取出传回来的参数error并与yes比较
    var success ='<%=request.getParameter("success")%>';
    if(success=='yes'){
        alert("留言成功！");
    }
    else if(success=='no'){
        alert("输入不能为空！");
    }
</script>
</body>

</html>