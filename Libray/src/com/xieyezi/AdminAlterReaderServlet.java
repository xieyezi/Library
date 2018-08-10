package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminAlterReaderServlet")
public class AdminAlterReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId = request.getParameter("id");
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");
        String Departments = request.getParameter("Departments");
        String Major = request.getParameter("Major");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        SystemAdOperation systemAdOperation = new SystemAdOperation();
        boolean flag1 = systemAdOperation.AlterForUser(UserId, UserName,Password);
        boolean flag2 = systemAdOperation.AlterForUserInfo(UserId, Departments, Major, Phone, Email);
        systemAdOperation.closeConnection();
        if (flag1 && flag2){
            response.sendRedirect("adminAlterReader.jsp?altr=yes");
        }
        else
            response.sendRedirect("adminAlterReader.jsp?check=no");

    }
}
