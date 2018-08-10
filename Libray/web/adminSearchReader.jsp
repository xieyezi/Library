<%@ page import="domain.SystemAdmin" %>
<%@ page import="java.util.Vector" %>
<%@ page import="domain.BookAdmin" %>
<%@ page import="domain.User" %>
<%@ page import="domain.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/29
  Time: 上午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    SystemAdmin systemAdmin = (SystemAdmin) session.getAttribute("sysadmin");
    if (systemAdmin==null){
        response.sendRedirect("login.jsp?islogin=no");return;
    }
    Vector<UserInfo> searchresult= (Vector<UserInfo>)request.getAttribute("searchresult");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统管理员-查询读者信息</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
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
                        <a href="javascript:;">欢迎你！<i class="am-icon-heart"></i>&nbsp;&nbsp;<span><%=systemAdmin.getAdminName()%></span> </a>
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
              <%=systemAdmin.getAdminName()%>
          </span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">

            <!-- <li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>-->
            <li class="sidebar-nav-link">
                <a href="adminAddReader.jsp">
                    <i class="am-icon-hand-lizard-o sidebar-nav-link-logo"></i> 新增读者
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminOutReader.jsp">
                    <i class="am-icon-hand-paper-o sidebar-nav-link-logo"></i> 删除读者
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminAlterReader.jsp">
                    <i class="am-icon-tags sidebar-nav-link-logo"></i> 修改读者信息
                    <!--<span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>-->
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminAddAd.jsp">
                    <i class="am-icon-map-o sidebar-nav-link-logo"></i> 录入图书馆管理员
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminOutAd.jsp">
                    <i class="am-icon-paint-brush sidebar-nav-link-logo"></i> 删除图书馆管理员
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminAlterAd.jsp">
                    <i class="am-icon-calendar sidebar-nav-link-logo"></i> 修改管理员信息
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminSearchReader.jsp">
                    <i class="am-icon-yelp sidebar-nav-link-logo"></i> 查询读者信息
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminSearchAd.jsp">
                    <i class="am-icon-child sidebar-nav-link-logo"></i> 查询管理员信息
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="adminPersonal.jsp">
                    <i class="am-icon-child sidebar-nav-link-logo"></i> 系统管理员中心
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
                            <div class="widget-title  am-cf">搜索读者信息</div>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6 am-u-lg-offset-3 am-u-md-offset-3"
                                 style="margin-bottom: 3%;">
                                <form action="./AdminSearchReaderServlet" method="post" id="searchForm">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" name="search" class="am-form-field "
                                               placeholder="读者ID / 读者姓名 / 学院 / 系" required="required">

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
                                        <th>读者ID</th>
                                        <th>读者姓名</th>
                                        <th>学院</th>
                                        <th>专业</th>
                                        <th>电话</th>
                                        <th>邮箱</th>
                                        <th>借阅上限</th>
                                        <th>借阅期限</th>
                                        <th>在借数量</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for (int i = 0;  searchresult != null && i < searchresult.size(); i++) {


                                    %>
                                    <tr class="even gradeX">

                                        <td class="am-text-middle"><%=searchresult.get(i).getUserId()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getUserName()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getDepartments()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getMajor()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getPhone()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getEmail()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getMax()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getTime()%>
                                        </td>
                                        <td class="am-text-middle"><%=searchresult.get(i).getLendedNum()%>
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

<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/amazeui.datatables.min.js"></script>
<script src="assets/js/dataTables.responsive.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    var error1 = '<%=request.getParameter("check")%>';

    if (error1 == 'no') {
        alert("查询失败！");
    }
    function onBlurBookId() {
        var UserId=document.getElementById("AdId").value
        location.href="./OutAdSearchServlet?AdId="+UserId.toString();
    }
</script>
</body>

</html>

