<%@ page import="domain.BookAdmin" %>
<%@ page import="domain.BorrowRecord" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/29
  Time: 上午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookAdmin bookadmin = (BookAdmin) session.getAttribute("bookadmin");
    if (bookadmin==null){
        response.sendRedirect("login.jsp?islogin=no");return;
    }
    Vector<BorrowRecord> searchresult = (Vector<BorrowRecord>) request.getAttribute("searchresult");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>查询借阅记录</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
<script src="assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="index.jsp"><img src="assets/images/libLog.jpg" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list">
						<span>

                </span>
            </div>
            <!-- 搜索 -->
            <div class="am-fl tpl-header-search">
                <form class="tpl-header-search-form" action="javascript:;">
                    <button class="tpl-header-search-btn am-icon-search"></button>
                    <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
                </form>
            </div>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你！<i class="am-icon-heart"></i>&nbsp;&nbsp;<span><%=bookadmin.getAdName()%></span> </a>
                    </li>
                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="exit.jsp">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
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
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="assets/img/admin01.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              <%=bookadmin.getAdName()%>
          </span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">

            <!-- <li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>-->
            <li class="sidebar-nav-link">
                <a href="adBorrowBook.jsp">
                    <i class="am-icon-hand-lizard-o sidebar-nav-link-logo"></i> 读者借书
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adReturnBook.jsp">
                    <i class="am-icon-hand-paper-o sidebar-nav-link-logo"></i> 读者还书
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adAddBook.jsp">
                    <i class="am-icon-tags sidebar-nav-link-logo"></i> 新书入库
                    <!--<span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>-->
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adOutBook.jsp">
                    <i class="am-icon-map-o sidebar-nav-link-logo"></i> 图书出库
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adAlterBook.jsp">
                    <i class="am-icon-paint-brush sidebar-nav-link-logo"></i> 修改图书信息
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adCheckBook.jsp">
                    <i class="am-icon-calendar sidebar-nav-link-logo"></i> 查询借阅记录
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adSearchBook.jsp">
                    <i class="am-icon-yelp sidebar-nav-link-logo"></i> 查询图书信息
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adPersonal.jsp">
                    <i class="am-icon-child sidebar-nav-link-logo"></i> 管理员中心
                </a>
            </li>

        </ul>

    </div>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content ">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">借阅记录</div>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6 am-u-lg-offset-3 am-u-md-offset-3"
                                 style="margin-bottom: 3%;">
                                <form action="./AdCheckBookServlet" method="post" id="searchForm">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" name="search" class="am-form-field "
                                               placeholder="图书书名 / 图书编号 / 借阅号">

                                        <span class="am-input-group-btn ">
                                         <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="submit"></button>
                                        </span>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>
                                        <th>图书缩略图</th>
                                        <th>图书书名</th>
                                        <th>应还日期</th>
                                        <th>实还日期</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for (int i = 0;  searchresult != null && i < searchresult.size(); i++) {

                                    %>
                                    <tr class="even gradeX">
                                        <td>
                                            <img src="assets/img/book0<%=i+1%>.jpg" class="tpl-table-line-img" alt="">
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getBookName()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getShouldTime()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getReturnTime()%>
                                        </td>
                                    </tr>
                                    <%}%>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled">
                                            <a href="#">«</a>
                                        </li>
                                        <li class="am-active">
                                            <a href="#">1</a>
                                        </li>
                                        <li>
                                            <a href="#">2</a>
                                        </li>
                                        <li>
                                            <a href="#">3</a>
                                        </li>
                                        <li>
                                            <a href="#">4</a>
                                        </li>
                                        <li>
                                            <a href="#">5</a>
                                        </li>
                                        <li>
                                            <a href="#">»</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>
