<%@ page import="domain.BookAdmin" %>
<%@ page import="domain.BookInfo" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xieyezi
  Date: 2018/5/29
  Time: 上午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>

<!DOCTYPE html>
<%
    BookAdmin bookadmin = (BookAdmin) session.getAttribute("bookadmin");
    if (bookadmin==null){
        response.sendRedirect("login.jsp?islogin=no");return;
    }
    Vector<BookInfo> bookInfo = (Vector<BookInfo>) request.getAttribute("bookInfo");
    String UserId =(String) request.getAttribute("UserId");
//    System.out.println(UserId);
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>图书管理员-读者借书</title>
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

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 读者 <small>借书</small></div>
                    <p class="page-header-description">读者借书</p>
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
                            <div class="widget-title am-fl">读者借书</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-line-form " action="./AdBorrowCheckServlet" method="post">

                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">借阅号<span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="UserId" name="UserId" placeholder="请输入读者借阅号" >

                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label  class="am-u-sm-3 am-form-label">图书编号 <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="BookId" name="BookId" placeholder="请输入图书的编号">

                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">验证</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>
                                        <th>图书缩略图</th>
                                        <th>图书书名</th>
                                        <th>作者</th>
                                        <th>出版社</th>
                                        <th>出版日期</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for (int i = 0; bookInfo!=null && i < bookInfo.size(); i++) {

                                    %>
                                    <tr class="even gradeX">
                                        <td>
                                            <img src="assets/img/book0<%=i+1%>.jpg" class="tpl-table-line-img" alt="">
                                        </td>
                                        <td class="am-text-middle"><%=bookInfo.get(i).getBookName()%>
                                        </td>
                                        <td class="am-text-middle"><%=bookInfo.get(i).getAuthor()%>
                                        </td>
                                        <td class="am-text-middle"><%=bookInfo.get(i).getPublishCompany()%>
                                        </td>
                                        <td class="am-text-middle"><%=bookInfo.get(i).getComeUpTime()%>
                                        </td>
                                        <td class="am-text-middle">
                                            <div class="tpl-table-black-operation">
                                                <a href="./AdBorrowServlet?UserId=<%=UserId%>&BookId=<%=bookInfo.get(i).getBookId()%>">
                                                    <i class="am-icon-pencil"></i> 借阅
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <%}%>
                                    <!-- more data -->
                                    </tbody>
                                </table>
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
    var error = '<%=request.getParameter("check")%>';
    var error1 = '<%=request.getParameter("borrow")%>';
    <%--<%System.out.println("sadadassa");%>--%>
    <%--<%System.out.println(request.getParameter("check"));%>--%>
    if (error == 'no') {
        alert("验证失败！");
    }
    if (error1 == 'yes') {
        alert("借阅成功！");
    }
</script>
</body>

</html>
