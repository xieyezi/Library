package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminOutAdServlet")
public class AdminOutAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String AdId =request.getParameter("id");
        System.out.println(AdId);
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        boolean flag =systemAdOperation.outAd(AdId);
        systemAdOperation.closeConnection();
        if (flag){
            response.sendRedirect("adminOutAd.jsp?out=yes");
        }
        else {
            response.sendRedirect("adminOutAd.jsp?check=no");
        }
    }
}
