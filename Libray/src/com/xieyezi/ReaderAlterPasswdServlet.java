package com.xieyezi;

import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReaderAlterPasswdServlet")
public class ReaderAlterPasswdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId =request.getParameter("UserId");
        String newPassword =request.getParameter("newPassword");
        Useroperation useroperation =new Useroperation();
        useroperation.AlterPasswd(UserId,newPassword);
        useroperation.closeConnection();
        response.sendRedirect("login.jsp?change=yes");
    }
}
