package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminPersonalServlet")
public class AdminPersonalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String AdminId=request.getParameter("AdminId");
        String AdminPassword=request.getParameter("newPassword");
        String AdminPhone=request.getParameter("AdminPhone");
        String AdminEmail=request.getParameter("AdminEmail");
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        boolean flag = systemAdOperation.changeAdmin(AdminId,AdminPassword,AdminPhone,AdminEmail);
        systemAdOperation.closeConnection();
        if (flag){
            response.sendRedirect("login.jsp?change=yes");
        }
        else {
            response.sendRedirect("adminPersonal.jsp?check=no");
        }
    }
}
