<%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/4/25
  Time: 下午4:38
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

<div class="container margin-top">
    <div class="portfolio-wrapper">
        <button class="nav">
                <span class="icon-container">
            <span class="line line01"></span>
                <span class="line line02"></span>
                <span class="line line03"></span>
                <span class="line line04"></span>
                </span>
        </button>
        <div class="works-filter">
            <a href="javascript:void(0)" class="filter active" data-filter="mix">全部</a>
            <a href="javascript:void(0)" class="filter" data-filter="branding">心情</a>
            <a href="javascript:void(0)" class="filter" data-filter="web">颜色</a>
            <a href="javascript:void(0)" class="filter" data-filter="graphic">随机</a>
        </div>
        <div class="js-masonry">
            <div class="row" id="work-grid">
                <!-- Begin of Thumbs Portfolio -->
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model1.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">250</span>
                            </a>
                            <div class="details">
                                <span class="title">紫色</span>
                                <span class="info">忧郁的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model1"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix web">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model2.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">60</span>
                            </a>
                            <div class="details">
                                <span class="title">蓝色</span>
                                <span class="info">悠闲的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model2"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix graphic">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model3.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">1060</span>
                            </a>
                            <div class="details">
                                <span class="title">黄色</span>
                                <span class="info">激动的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model3"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model4.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">900</span>
                            </a>
                            <div class="details">
                                <span class="title">红色</span>
                                <span class="info">急切的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model4"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model5.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">979</span>
                            </a>
                            <div class="details">
                                <span class="title">黄色</span>
                                <span class="info">激动的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model5"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model6.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">1024</span>
                            </a>
                            <div class="details">
                                <span class="title">淡蓝色</span>
                                <span class="info">闲适的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model6"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model7.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">2048</span>
                            </a>
                            <div class="details">
                                <span class="title">粉色</span>
                                <span class="info">可爱的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model7"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model10.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">256</span>
                            </a>
                            <div class="details">
                                <span class="title">绿色</span>
                                <span class="info">平静的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model10"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="assets/images/work/model8.png" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="fa fa-heart"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">256</span>
                            </a>
                            <div class="details">
                                <span class="title">深蓝色</span>
                                <span class="info">沉重的心情</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model8"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="load-more">
            <a href="javascript:void(0)" id="load-more"><i class="fa fa-refresh"></i></a>
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
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/isotope.pkgd.min.js"></script>
<script src="assets/js/imagesloaded.pkgd.min.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/classie.js"></script>
</body>

</html>