<%@ page import="domain.SystemAdmin" %>
<%@ page import="domain.UserInfo" %>
<%@ page import="java.util.Vector" %>
<%@ page import="opration.Useroperation" %>
<%@ page import="domain.User" %><%--
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
    Vector<User> user =null;
    Vector<UserInfo> searchresult = (Vector<UserInfo>) request.getAttribute("searchresult");
    if (searchresult!=null){
        Useroperation useroperation =new Useroperation();
        user = useroperation.getUserName(searchresult.get(0).getUserId());
    }
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统管理员-修改读者信息</title>
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

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 删除 <small>读者</small></div>
                    <p class="page-header-description">删除读者</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置</button>
                </div>
            </div>

        </div>

        <div class="row-content am-cf">
            <div class="row">

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">删除读者信息</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-line-form " action="./AdminAlterReaderServlet" method="post">
                                <%
                                    if (searchresult==null){
                                %>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">读者ID <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="UserId" name="UserId" placeholder="请输入读者ID" required="required" onblur="onBlurBookId()">

                                    </div>
                                </div>
                                <%}%>

                                <%
                                    for (int i=0;searchresult!=null && user!=null && i<searchresult.size();i++){

                                %>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">读者ID <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="id" name="id" value="<%=searchresult.get(i).getUserId()%>" readonly="readonly">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">读者姓名 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="UserName" name="UserName" value="<%=user.get(i).getUserName()%>" >

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">登录密码 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Password" name="Password" value="<%=user.get(i).getPassword()%>" >

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">学院 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Departments" name="Departments" value="<%=searchresult.get(i).getDepartments()%>">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">专业 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Major" name="Major" value="<%=searchresult.get(i).getMajor()%>">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">电话 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Phone" name="Phone" value="<%=searchresult.get(i).getPhone()%>">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">邮箱 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Email" name="Email" value="<%=searchresult.get(i).getEmail()%>">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">借阅上限 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Max" name="Max" value="<%=searchresult.get(i).getMax()%>" readonly="readonly">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">借阅期限 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="Time" name="Time" value="<%=searchresult.get(i).getTime()%>" readonly="readonly">

                                    </div>
                                </div>
                                <%}%>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">确认修改</button>
                                    </div>
                                </div>
                            </form>
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
    var error = '<%=request.getParameter("altr")%>';
    var error1 = '<%=request.getParameter("check")%>';
    var error2 = '<%=request.getParameter("search")%>';
    if (error == 'yes') {
        alert("修改成功！");
    }
    if (error1 == 'no') {
        alert("修改失败！");
    }
    if (error2 == 'no') {
        alert("数据库里面无该读者！");
    }
    function onBlurBookId() {
        var UserId=document.getElementById("UserId").value
        location.href="./AlterReaderCheckServlet?UserId="+UserId.toString();
    }
</script>
</body>

</html>

