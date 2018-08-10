package com.xieyezi;

import domain.UserInfo;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/AlterReaderCheckServlet")
public class AlterReaderCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId = request.getParameter("UserId");
        Useroperation useroperation =new Useroperation();
        Vector<UserInfo> userInfo = useroperation.USerInfoSearch(UserId);
        useroperation.closeConnection();
        if (userInfo.size()>0){
            request.setAttribute("searchresult",userInfo);
            request.getRequestDispatcher("adminAlterReader.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("adminAlterReader.jsp?search=no");
        }
    }
}
