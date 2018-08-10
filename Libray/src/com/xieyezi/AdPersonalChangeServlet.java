package com.xieyezi;

import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdPersonalChangeServlet")
public class AdPersonalChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String AdId=request.getParameter("AdId");
        String AdPassword=request.getParameter("newPassword");
        String AdPhone=request.getParameter("Phone");
        String AdEmail=request.getParameter("Email");
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        bookAdminOperation.AlterPersonal(AdId,AdPassword,AdPhone,AdEmail);
        bookAdminOperation.closeConnection();
        response.sendRedirect("login.jsp?change=yes");
    }
}
