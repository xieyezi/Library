package com.xieyezi;

import domain.User;
import domain.UserInfo;
import opration.SystemAdOperation;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/AdminSearchReaderServlet")
public class AdminSearchReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search=request.getParameter("search");
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        Vector<UserInfo> userInfos =systemAdOperation.queryReader(search);
        systemAdOperation.closeConnection();
        if (userInfos.size()>0){
            request.setAttribute("searchresult",userInfos);
            request.getRequestDispatcher("adminSearchReader.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("adminSearchReader.jsp?check=no");
        }

    }
}
