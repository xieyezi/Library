package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminAddReaderServlet")
public class AdminAddReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId =request.getParameter("UserId");
        String UserName =request.getParameter("UserName");
        String Password =request.getParameter("Password");
        String Departments =request.getParameter("Departments");
        String Major =request.getParameter("Major");
        String Phone =request.getParameter("Phone");
        String Email =request.getParameter("Email");
        String Max1 =request.getParameter("Max");
        String Time1 =request.getParameter("Time");
        int Max=Integer.parseInt(Max1);
        int Time =Integer.parseInt(Time1);
        int LendedNum=0;
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        systemAdOperation.addReaderToUser(UserId,UserName,Password);
        systemAdOperation.addReaderToUserInfo(UserId,Departments,Major,Phone,Email,Max,Time,LendedNum);
        systemAdOperation.closeConnection();
        response.sendRedirect("adminAddReader.jsp?add=yes");
    }
}
