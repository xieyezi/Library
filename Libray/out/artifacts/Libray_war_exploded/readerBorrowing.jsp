<%@ page import="domain.User" %>
<%@ page import="domain.BorrowRecord" %>
<%@ page import="opration.BookAdminOperation" %>
<%@ page import="opration.BorrowRecordOperation" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/30
  Time: 下午1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    if (user==null){
        response.sendRedirect("login.jsp?islogin=no");return;
    }
    String UserId =user.getUserId();
    BorrowRecordOperation borrowRecordOperation =new BorrowRecordOperation();
    Vector<BorrowRecord> records= borrowRecordOperation.getBorrowing(UserId);
    borrowRecordOperation.closeConnection();

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>在借记录</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <script src="assets/js/echarts.min.js"></script>
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
            <a href="javascript:;"><img src="assets/images/libLog.jpg" alt=""></a>
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
                        <a href="javascript:;">欢迎你！<i class="am-icon-heart"></i>&nbsp;&nbsp;<span><%=user.getUserName()%></span> </a>
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
              <%=user.getUserName()%>
          </span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">

            <!-- <li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>-->
            <li class="sidebar-nav-link">
                <a href="readerPersonal.jsp">
                    <i class="am-icon-child sidebar-nav-link-logo"></i> 基本资料
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="readerAlterData.jsp">
                    <i class="am-icon-tag sidebar-nav-link-logo"></i> 修改资料
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="readerAlterPaswd.jsp">
                    <i class="am-icon-tags sidebar-nav-link-logo"></i> 修改密码
                    <!--<span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>-->
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="readerBorrowing.jsp">
                    <i class="am-icon-map-o sidebar-nav-link-logo"></i> 在借图书
                    <!--<span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>-->
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="readerBorrowed.jsp">
                    <i class="am-icon-calendar sidebar-nav-link-logo"></i> 借阅记录
                    <p id="time1"></p>
                </a>
            </li>
        </ul>

    </div>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-yelp page-header-heading-icon"></span> 在借记录
                        <small>在借记录</small>
                    </div>

                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <%--<button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置</button>--%>
                </div>
            </div>

        </div>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">已借:<%=records.size()%>&nbsp;&nbsp;&nbsp;&nbsp;剩余可借:<%=10-records.size()%></div>

                        </div>
                        <div class="widget-body  am-fr">

                            <%--<div class="am-u-sm-12 am-u-md-6 am-u-lg-6">--%>
                                <%--<div class="am-form-group">--%>
                                    <%--<div class="am-btn-toolbar">--%>
                                        <%--<div class="am-btn-group am-btn-group-xs">--%>
                                            <%--//已借，还可以借--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>

                                        <th>序号</th>
                                        <th>借阅号</th>
                                        <th>图书名</th>
                                        <th>应还日期</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%

                                        for (int i = 0; i < records.size(); i++) {

                                    %>
                                    <tr class="even gradeC">
                                        <td class="am-text-middle"><%=i+1%>
                                        </td>
                                        <td class="am-text-middle"><%=records.get(i).getBorrowID()%>
                                        </td>
                                        <td class="am-text-middle"><%=records.get(i).getBookName()%>
                                        </td>
                                        <td class="am-text-middle"><%=records.get(i).getShouldTime()%>
                                        </td>
                                        </td>
                                    </tr>
                                    <!-- more data -->
                                    <%
                                        }
                                    %>
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
<script src="assets/js/amazeui.datatables.min.js"></script>
<script src="assets/js/dataTables.responsive.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>


