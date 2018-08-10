package com.xieyezi;

import domain.User;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReaderAlterDataServlet")
public class ReaderAlterDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId =request.getParameter("UserId");
        String Phone =request.getParameter("Phone");
        String Email =request.getParameter("Email");
        Useroperation useroperation =new Useroperation();
        useroperation.AlterData(UserId,Phone,Email);
        useroperation.closeConnection();
        response.sendRedirect("readerPersonal.jsp");
    }
}
