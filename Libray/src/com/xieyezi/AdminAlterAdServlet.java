package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminAlterAdServlet")
public class AdminAlterAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String AdId =request.getParameter("id");
        String AdName =request.getParameter("AdName");
        String AdPassword =request.getParameter("AdPassword");
        String AdPhone =request.getParameter("AdPhone");
        String AdEmail =request.getParameter("AdEmail");
        SystemAdOperation systemAdOperation=new SystemAdOperation();
        boolean flag= systemAdOperation.alterAd(AdId,AdName,AdPassword,AdPhone,AdEmail);
        systemAdOperation.closeConnection();
        if (flag){
            response.sendRedirect("adminAlterAd.jsp?altr=yes");
        }
        else {
            response.sendRedirect("adminAlterAd.jsp?check=no");
        }
    }
}
