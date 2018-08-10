package com.xieyezi;


import domain.BookAdmin;
import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/OutAdSearchServlet")
public class OutAdSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String AdId = request.getParameter("AdId");
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        Vector<BookAdmin> AdInfo = bookAdminOperation.getAdInfo(AdId);
        bookAdminOperation.closeConnection();
        if (AdInfo.size()> 0){
            request.setAttribute("searchresult",AdInfo);
            request.getRequestDispatcher("adminOutAd.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("adminOutAd.jsp?search=no");
        }

    }
}
