package com.xieyezi;

import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdoutBookServlet")
public class AdoutBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String BookId =request.getParameter("id");
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        boolean flag=bookAdminOperation.outBookCheck(BookId);
        if (flag){
            bookAdminOperation.outBook(BookId);
            bookAdminOperation.closeConnection();
            response.sendRedirect("adOutBook.jsp?out=yes");
        }
        else {
            bookAdminOperation.closeConnection();
            response.sendRedirect("adOutBook.jsp?check=no");
        }

    }
}
