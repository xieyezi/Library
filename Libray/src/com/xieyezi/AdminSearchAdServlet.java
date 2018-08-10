package com.xieyezi;

import domain.BookAdmin;
import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/AdminSearchAdServlet")
public class AdminSearchAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search=request.getParameter("search");
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        Vector<BookAdmin> bookAdmins =systemAdOperation.queryAd(search);
        systemAdOperation.closeConnection();
        if (bookAdmins.size()>0){
            request.setAttribute("searchresult",bookAdmins);
            request.getRequestDispatcher("adminSearchAd.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("adminSearchAd.jsp?check=no");
        }

    }
}
